package org.example.C03_arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public static void main(String[] args) {
        // > n/3 times => At max we can have 2 majority elements
        int arr[] = {1,1,1,3,3,2,2,2};
        majorityElement_BF(arr);
        majorityElement_BT(arr);
        majorityElement_OP(arr);
    }

    private static void majorityElement_OP(int[] arr) {
        int e1  = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE, count1= 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count1==0 && e2!=arr[i]){
                e1 = arr[i];
                count1  = 1;
            }else if(count2==0 && e1!=arr[i]){
                e2 = arr[i];
                count2 = 1;
            }else if(e1 == arr[i]){
                count1++;
            }else if(e2==arr[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        // Verify The element which we get is greather than n/3
        count1 = 0; count2=0;
        for (int i = 0; i < arr.length; i++) {
            if(e1==arr[i]) count1++;
            if(e2==arr[i]) count2++;
        }
        if(count1>arr.length/3) System.out.println(e1);
        if(count2>arr.length/3) System.out.println(e2);
    }

    private static void majorityElement_BT(int[] arr) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>arr.length/3){
                System.out.println(arr[i]);
            }
        }
    }

    private static void majorityElement_BF(int[] arr) {
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if(list.size()==0 || list.get(0)!=arr[i]) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }
                if (count > arr.length / 3) {
                    list.add(arr[i]);
                }
            }

            if(list.size()==2){
                break;
            }
        }
        System.out.println(list);
    }
}
