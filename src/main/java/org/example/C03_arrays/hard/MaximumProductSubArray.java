package org.example.C03_arrays.hard;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, -3, -2, 0, 4, 1, 2};
        maxProductSubArrayBF(arr);
        maxProductSubArrayOP(arr);
    }

    private static void maxProductSubArrayOP(int[] arr) {
        int prefix = 1, suffix = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[arr.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        System.out.println(max);
    }

    private static void maxProductSubArrayBF(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                max = Math.max(product, max);
            }
        }
        System.out.println(max);
    }
}
