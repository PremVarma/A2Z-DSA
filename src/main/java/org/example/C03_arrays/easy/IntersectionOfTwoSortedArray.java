package org.example.C03_arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1,2,2,4,4,6,8,9};
        int arr2[] = {1,2,4,8,10};
//        bruteForce(arr1,arr2);
        optimalSolution(arr1,arr2);
    }

    private static void optimalSolution(int[] arr1, int[] arr2) {
        int i=0,j=0;
        List list  = new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                j++;
            }
            else if(arr2[j]>arr1[i]){
                i++;
            }else{
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        System.out.println(list);
    }

    private static void bruteForce(int[] arr1, int[] arr2) {
        int visited[] = new int[arr2.length];
        ArrayList list = new ArrayList();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j] && visited[j]==0){
                      list.add(arr1[i]);
                      visited[j] = 1;
                      break;
                }
                if(arr2[j]>arr1[i]){
                    break;
                }
            }
        }
        System.out.println(list);
    }
}
