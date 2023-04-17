package org.example.C03_arrays.easy;

import java.util.*;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1,1,2,3,5};
        int arr2[] = {1,2,4,6};
        System.out.println(Arrays.toString(bruteForceUnion(arr1,arr2)));
        //Union Of two sorted Array
        System.out.println(optimalUnion(arr1,arr2));
    }

    private static List optimalUnion(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> list =  new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                if(list.size()==0 || list.get(list.size()-1)!=arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }else{
               if(list.size()==0 || list.get(list.size()-1)!=arr2[j]){
                   list.add(arr2[j]);
               }
               j++;
            }
        }
        while(i < arr1.length){
            if(list.get(list.size()-1)!=arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }

        while(j < arr2.length){
            if(list.get(list.size()-1)!=arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }

        return list;
    }

    private static int[] bruteForceUnion(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        int result[] = new int[set.size()];
        int index = 0;
        for(int num:set){
            result[index]  = num;
            index++;
        }
        return result;
    }
}
