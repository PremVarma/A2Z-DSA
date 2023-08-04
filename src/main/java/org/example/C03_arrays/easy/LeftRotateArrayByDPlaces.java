package org.example.C03_arrays.easy;

import java.util.Arrays;
import java.util.Collections;

public class LeftRotateArrayByDPlaces {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
//        bruteForce(arr,7);
//        System.out.println(Arrays.toString(arr));
//        solution(arr,2);
//        System.out.println(Arrays.toString(arr));
        optimalSolution(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void optimalSolution(int[] arr, int d) {
        d = d % arr.length - 1;
        //reverse all element from 0,d
        reverse(arr, 0, d - 1);
        //reverse all element from d,arr.length-1
        reverse(arr, d, arr.length - 1);
        //reverse all element from 0,arr.length-1
        reverse(arr, 0, arr.length - 1);
    }

    private static void bruteForce(int[] arr, int d) {
        int temp[] = new int[d];
        d = d % arr.length;
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        for (int i = arr.length - d; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length - d)];
        }
    }

    private static void solution(int[] arr, int rotate) {
        for (int i = 0; i < rotate % arr.length; i++) {
            leftRotate(arr);
        }
    }

    private static void leftRotate(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
}
