package com.example.JavaInterviewPrograms;

import com.example.JavaInterviewPrograms.model.Fruits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsDemo {
    //Display the Fruit names of low calories<100 fruits i.e. calories < 100 sorted in
    //descending order of calories
    public static void main(String[] args){
        List<Fruits> fruits=new ArrayList<>();
        fruits.add(new Fruits("Mango",150,500,"Orange"));
        fruits.add(new Fruits("Apple",80,200,"Red"));
        fruits.add(new Fruits("Grapes",70,100,"Green"));
        fruits.add(new Fruits("Orange",60,90,"Orange"));
        fruits.add(new Fruits("Chiku",110,90,"Choclate"));

        System.out.println(fruits.stream().filter(f->f.getCalories()<100).
                sorted((f1,f2)->f2.getCalories().compareTo(f1.getCalories())).
                map(f->f.getName()).collect(Collectors.toList()));

        fruits.stream().filter(f->f.getCalories()<100).
                sorted((f1,f2)->f2.getCalories().compareTo(f1.getCalories())).

                forEach(f3-> System.out.println(f3.getName()));

    }
}
