package com.topics.recursion;

import java.util.ArrayList;

public class PrintSubsequencesWithSumK {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        printSubsequences(arr,0,new ArrayList<>(),0,2);
    }

    private static void printSubsequences(int[] arr, int i, ArrayList list, int initialSum,int sum) {
        if(i == arr.length){
            if(sum==initialSum){
                System.out.println(list);
            }
            return;
        }
        list.add(arr[i]);
        initialSum+=arr[i];
        printSubsequences(arr,i+1,list,initialSum,sum);
        initialSum-=arr[i];
        list.remove(list.size()-1);
        printSubsequences(arr,i+1,list,initialSum,sum);
    }
}
