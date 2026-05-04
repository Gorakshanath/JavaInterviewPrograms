package com.resttest.RestDemo1.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Test {

    public static void main(String[] args) {
        String s="this project is completed by guru and this project documentation is completed by guru";
        String result=s.replaceAll("\\s","");
        System.out.println(result);
        //Map<String,Long> hm=list.stream().collect(Collectors.groupingBy(s1->s1,Collectors.counting()));
        //System.out.println(hm);
    }

}
