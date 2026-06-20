package com.example.JavaInterviewPrograms;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InterviewAskedPrograms {
    public static void main(String[] args){
        //First non-repeating character — return the first character
        // that appears only once. "swiss" → 'w'
        firstNonRepeatingCharacter("hdfhfxaswiss");
    }
    private static void firstNonRepeatingCharacter(String word){
        String[] array=word.split("");
        Optional<String> duplicateCharacter=Arrays.asList(array).stream()
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1).
                map(Map.Entry::getKey).findFirst();
        if(duplicateCharacter.isPresent()) {
            System.out.println(duplicateCharacter.get());
        }
    }
}
