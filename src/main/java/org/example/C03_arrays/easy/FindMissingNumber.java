package org.example.C03_arrays.easy;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int arr[] = {1,2,4};
        int n = 4;
        System.out.println(bruteForce(arr,n));
        System.out.println(betterSolution(arr,n));
        System.out.println(optimalSolutionOne(arr,n));
        System.out.println(optimalSolutionTwo(arr,n));
    }

    private static int optimalSolutionTwo(int[] arr, int n) {
        int xor1 = 0;
        int xor2=0;
        for (int i = 0; i < n-1; i++) {
            xor2^=arr[i];
            xor1^=i+1;
        }
        xor1^=n;
        return xor1^xor2;
        // 2 ^ 0 = 2
        //2 ^ 2 = 0
    }

    private static int optimalSolutionOne(int[] arr, int n) {
        int sum = n*(n+1)/2;
        for (int i = 0; i < arr.length; i++) {
            sum-=arr[i];
        }
        return sum;
    }

    private static int betterSolution(int[] a, int N) {
        int hash[] = new int[N + 1]; //hash array

        for (int i = 0; i < N - 1; i++)
            hash[a[i]]++;

        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int bruteForce(int[] a,int N) {
        for (int i = 1; i <= N; i++) {
            int flag = 0;
            for (int j = 0; j < N - 1; j++) {
                if (a[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;
        }
        return -1;
    }
}
