package com.example.JavaInterviewPrograms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordFromString {

    public static void main(String[] args){
        String str = "Java Spring Boot";

//        String result = Arrays.stream(str.split(" "))
//                .map(word -> new StringBuilder(word).reverse().toString())
//                .collect(Collectors.joining(" "));
//
//        System.out.println(result);

        String[] words = str.split(" ");

        String result = "";

        for (String word : words) {

            char[] chars = word.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                result = result + chars[i];
            }

            result = result + " ";
        }

        System.out.println(result.trim());
    }
}
