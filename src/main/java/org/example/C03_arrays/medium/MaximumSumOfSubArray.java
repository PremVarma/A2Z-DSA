package org.example.C03_arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;

// Kadane's Algorithm
public class MaximumSumOfSubArray {
    public static void main(String[] args) {
        int arr[] = {2,3,4,1,-2,4,-4,-3,-2,-1,-2,1};
        System.out.println(maxSubarraySum_BF(arr,arr.length));
        System.out.println(maxSubarraySum_BT(arr,arr.length));
        System.out.println(maxSubarraySum_OP(arr,arr.length));
        System.out.println(Arrays.toString(maxSubarraySumPrintSubArray_OP(arr,arr.length)));
    }

    private static int[] maxSubarraySumPrintSubArray_OP(int[] arr, int n) {
        int ansStart=-1,andEnd = -1;
        int start = 0;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum==0){
                start = i;
            }
            sum+=arr[i];
            if(sum>maxi) {
                maxi = max(maxi, sum);
                ansStart = start;
                andEnd = i;
            }
            if(sum <=0 ){
                sum = 0;
            }
        }
        return new int[]{ansStart,andEnd};
    }

    private static int maxSubarraySum_BT(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxi = max(maxi, sum);
            }
        }
        return maxi;
    }

    private static int maxSubarraySum_OP(int[] arr, int length) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum <=0 ){
                sum = 0;
            }
            maxi = max(maxi,sum);
        }
        return maxi;
    }

    static int maxSubarraySum_BF(int arr[],int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // subarray = arr[i.....j]
                int sum = 0;
                //add all the elements of subarray:
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = max(maxi, sum);
            }
        }
        return maxi;
    }
}
