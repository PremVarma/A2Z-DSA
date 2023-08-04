package org.example.C03_arrays.medium;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 4, 6};
        solution(arr, 10);
    }

    private static void solution(int[] arr, int k) {
        int start = 0, end = 0, sum = 0;
        while (start < arr.length) {
            while (end < arr.length && sum + arr[end] <= k) {
                sum += arr[end++];
            }
            if (sum == k) {
                for (int i = start; i < end; i++) {
                    System.out.println(arr[i]);
                }
                System.out.println("Next");
            }
            sum -= arr[start];
            start++;
        }
    }
}
