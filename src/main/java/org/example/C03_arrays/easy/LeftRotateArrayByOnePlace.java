package org.example.C03_arrays.easy;

import java.util.Arrays;

public class LeftRotateArrayByOnePlace {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        solution(arr);
    }

    private static void solution(int[] arr) {
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = last;
        System.out.println(Arrays.toString(arr));
    }
}
