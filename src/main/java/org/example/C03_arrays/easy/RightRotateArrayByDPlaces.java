package org.example.C03_arrays.easy;

import java.util.Arrays;

public class RightRotateArrayByDPlaces {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        rightRotateUsingTempArray(arr, 4, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void rightRotateUsingTempArray(int[] arr, int d, int n) {
        if (n == 0) return;
        d = d % n;
        if (d == 0) return;

        int temp[] = new int[d];

        for (int i = n - d; i < n; i++) {
            temp[i - (n - d)] = arr[i];
        }

        for (int i = n - d - 1; i >= 0; i--) {
            arr[i + d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }
    }

    static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rightRotate(int arr[], int n, int d) {

        if (n == 0) return;

        // Get the effective number of rotations:
        d = d % n;

        //step 1: reverse last d elements:
        reverse(arr, n - d, n - 1);

        //step 2: reverse first (n-d) elements:
        reverse(arr, 0, n - d - 1);

        //step 3: reverse whole array:
        reverse(arr, 0, n - 1);
    }
}
