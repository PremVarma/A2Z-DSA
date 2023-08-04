package org.example.C03_arrays.medium;

import java.util.HashMap;

public class NumberOfSubarrayWithSumK {
    public static void main(String[] args) {
        int arr[] = {3,-3,1,1,1};
        System.out.println(solution_BF(arr,3));
        System.out.println(solution_OP(arr,3));
    }

    private static int solution_OP(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0,preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum+=arr[i];
            int remove =  preSum-k;
            count += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    private static int solution_BF(int[] arr,int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];

                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
