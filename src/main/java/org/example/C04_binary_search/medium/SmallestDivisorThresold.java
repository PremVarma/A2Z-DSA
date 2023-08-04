package org.example.C04_binary_search.medium;

import java.util.Arrays;

public class SmallestDivisorThresold {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisor_BF(arr, limit);
        int ans_op = smallestDivisor_OP(arr, limit);
        System.out.println("The minimum divisor is: " + ans_op);
    }

    private static int smallestDivisor_OP(int[] arr, int limit) {
        int low = 1, high = Arrays.stream(arr).max().getAsInt();
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean possible = possibleSum(arr, mid, limit);
            if (possible) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean possibleSum(int[] arr, int mid, int limit) {
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += Math.ceil((double) (arr[j]) / (double) (mid));
        }
        return sum <= limit;
    }

    private static int smallestDivisor_BF(int[] arr, int limit) {
        int max = Arrays.stream(arr).max().getAsInt();
        int ans = -1;
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += Math.ceil((double) (arr[j]) / (double) (i));
            }
            if (sum <= limit) {
                return i;
            }
        }
        return ans;
    }
}
