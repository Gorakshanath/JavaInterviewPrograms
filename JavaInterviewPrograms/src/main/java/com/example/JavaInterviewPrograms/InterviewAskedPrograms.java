package com.example.JavaInterviewPrograms;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewAskedPrograms {
    public static void main(String[] args){
        //First non-repeating
        // character — return the first character
        // that appears only once. "swiss" → 'w'
        firstNonRepeatingCharacterFromWord("hdfhfxaswiss");
        firstDuplicateCharacterFromWord("swiss");
    }
    private static void firstNonRepeatingCharacterFromWord(String word){
        String[] array=word.split("");
        Optional<String> duplicateCharacter=Arrays.asList(array).stream()
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1).
                map(Map.Entry::getKey).findFirst();
        if(duplicateCharacter.isPresent()) {
            System.out.println(duplicateCharacter.get());
        }
    }
    private static void firstDuplicateCharacterFromWord(String word){
        String[] array=word.split("");
        Set<String> set=new HashSet<>();
//        for(String c:array){
//            if(!set.add(c)){
//                System.out.println("First Duplicate Character :"+c);
//                break;
//            }
//        }
        // Java8
        Arrays.asList(array).stream().filter(c->!set.add(c)).forEach((System.out::println));
    }
}
