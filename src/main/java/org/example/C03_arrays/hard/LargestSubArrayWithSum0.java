package org.example.C03_arrays.hard;

import java.util.HashMap;

public class LargestSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 2, 3};
        solution_OP(arr);
    }

    public static void solution_OP(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = Math.max(max, i + 1);
            } else {
                if (map.get(sum) != null) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        System.out.println(max);
    }
}
