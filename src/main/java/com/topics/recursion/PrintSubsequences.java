package com.topics.recursion;

import java.util.ArrayList;

public class PrintSubsequences {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        printSubsequences(arr,0,new ArrayList());
    }

    static void printSubsequences(int arr[], int index, ArrayList list){
        if(index==arr.length){
            System.out.println(list);
            return;
        }
        //Take or Pick particular index
        list.add(arr[index]);
        printSubsequences(arr,index+1,list);
        //Do not Take or Pick particular index
        list.remove(list.size()-1);
        printSubsequences(arr,index+1,list);
    }
}
