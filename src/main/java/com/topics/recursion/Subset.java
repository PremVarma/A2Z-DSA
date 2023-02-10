package com.topics.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int arr[] = {3,1,4};
        ArrayList<Integer> ans = new ArrayList<>();
        getSubsetSumSubarray(0,arr,0,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    static void getSubsetSumSubarray(int i, int []arr, int sum,List<Integer> list){
        if(i==arr.length){
            list.add(sum);
            return;
        }
        getSubsetSumSubarray(i+1,arr,sum+arr[i],list);
        getSubsetSumSubarray(i+1,arr,sum,list);
    }
}
