package com.example.JavaInterviewPrograms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewAskedPrograms {
    public static void main(String[] args){
        //First non-repeating
        // character — return the first character
        // that appears only once. "swiss" → 'w'
       // firstNonRepeatingCharacterFromWord("hdfhfxaswiss");
       // firstDuplicateCharacterFromWord("swiss");
        //treeMapDemo();
        //Object camelCaseStringWithJoinBy;
        //camelCaseStringWithJoinByHash("hello good morning");
        //getMostFrequentWord();
        mostDuplicateWordAndFindIsLongestOrNot();
    }
    public static void mostDuplicateWordAndFindIsLongestOrNot(){
        //write java8 program to find most duplicate word and either that duplicate
    // word is longest or not among list
        String[] array={"Pen", "Pen","Pen","Pen","Pen", "Pencil","Pencil",
                "Note Book","Note Book", "Note Book", "Eraser", "Eraser"};
        Map<String,Long> map=Arrays.asList(array).stream().collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String longestWord=map.keySet().stream().max(
                Comparator.comparingInt(String::length)).orElse("");
        map.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(e->
        {
            System.out.println("Most Repeted Word :"+ e.getKey());
            System.out.println("Count :"+e.getValue());
            System.out.println("Is Longest "+ e.getValue().equals(longestWord));
        });
    }
    public static  void getMostFrequentWord(){

        //Return top K most frequent words
        //example
        // if same top k most 2 words then sort based on alphabet
        List<String> words = List.of(
                "java", "aws", "java", "spring",
                "aws", "java", "docker","aws"
        );

        int k=1;
        //First Way
        words.stream().collect(
                Collectors.groupingBy(w->w,TreeMap::new,Collectors.counting())).entrySet().
                stream().sorted(
                        (e1,e2)->e2.getValue().compareTo(e1.getValue())
                ).limit(k).forEach(System.out::println);
        // Second way
        List<String> topK = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return Long.compare(b.getValue(), a.getValue());
                    }
                    return a.getKey().compareTo(b.getKey());
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(topK);


    }
    public static void camelCaseStringWithJoinByHash(String senence){
       List<String> list= Arrays.asList(senence.split(" "));
       System.out.println(list.stream().map(w->w.substring(0,1).toUpperCase().concat(w.substring(1))).collect(
               Collectors.joining("#")));
    }
    private static void treeMapDemo() {
        Map<Integer,Integer> map=new TreeMap(new ComparatorTest());
        map.put(1,5);
        map.put(2,10);
        map.put(3,1);
        System.out.println(map);
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


        String s="HelLO World";
        System.out.println(Arrays.asList(s.split("")).stream().collect(Collectors.groupingBy((s1->s1),Collectors.counting())));
    }
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online





}
class ComparatorTest implements Comparator{
    public int compare(Object ob1,Object ob2){
         Integer obj1=(Integer) ob1;
         Integer obj2=(Integer)ob2;
         if(obj1<obj2){
             return 1;
         }
         else if(obj2<obj1){
             return -1;
         }
         else
         return 0;

    }
}
