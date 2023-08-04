package org.example.C03_arrays.medium;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = {2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(solution_OP(arr,arr.length)));
    }

    private static int[] solution_OP(int[] arr,int n) {
        // Decide breakpoin of dip
        int breakIndex = -1;
        for (int i = n-2; i >=0 ; i--) {
            if(arr[i]<arr[i+1]){
                breakIndex = i;
                break;
            }
        }
        if(breakIndex==-1){
            reverse(arr,0,n-1);
            return arr;
        }
        for (int i = n-1; i >breakIndex ; i--) {
            if(arr[i]>arr[breakIndex]){
                int temp = arr[i];
                arr[i] = arr[breakIndex];
                arr[breakIndex] = temp;
                break;
            }
        }
        reverse(arr,breakIndex+1,n-1);
        return arr;
    }

    public static void reverse(int arr[],int start,int end){
        while (start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
