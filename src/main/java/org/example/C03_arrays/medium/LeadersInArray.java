package org.example.C03_arrays.medium;

import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = {10,22,12,3,0,6};
        int ar2[] = {5,4,3,2,1};
        solution_BF(arr); // everything in right should be smaller
        solution_OP(arr);
    }

    private static void solution_OP(int[] arr) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list =  new ArrayList<>();
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i]>max){
                list.add(arr[i]);
            }
            max = Math.max(max,arr[i]);
        }
        System.out.println(list);
    }

    private static void solution_BF(int[] arr) {
        ArrayList<Integer> list =  new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]>arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader) list.add(arr[i]);
        }
        System.out.println(list);
    }
}
