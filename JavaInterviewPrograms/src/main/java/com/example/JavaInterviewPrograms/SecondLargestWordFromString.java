package com.example.JavaInterviewPrograms;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

public class SecondLargestWordFromString {

    public static void main(String[] arts){
        String s="Ram Shyam Ramesh Gorakshanath ";
        Optional<String> secondHighestWord=Arrays.asList(s.split(" ")).stream().sorted(
               (s1,s2)-> valueOf(s2.length()).compareTo(valueOf(s1.length()))).skip(1).findFirst();
        if(secondHighestWord.isPresent()){
        System.out.println(secondHighestWord.get()+" "+secondHighestWord.get().length());
        }
    }
}
