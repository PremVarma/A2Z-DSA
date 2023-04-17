package org.example.C03_arrays.easy;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int arr[]={1,22,5,7,1,10};
        largestElementBySorting(arr);
        System.out.println(largestElementOptimum(arr));
    }

    private static int largestElementOptimum(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    private static void largestElementBySorting(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}
