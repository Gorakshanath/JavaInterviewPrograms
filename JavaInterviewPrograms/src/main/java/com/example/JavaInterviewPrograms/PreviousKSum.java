package com.example.JavaInterviewPrograms;

import java.util.Arrays;

public class PreviousKSum {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5,6};
        int k=3;
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j>i-k && j>=0;j--){
                sum += arr[j];
            }
            result[i] = sum;
        }
        System.out.println("Result: " + Arrays.toString(result));
    }
}
