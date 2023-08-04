package org.example.C04_binary_search.medium;

import java.util.Arrays;

public class DaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        //int ans = roseGarden_BF(arr, k, m);
        int ans_op = roseGarden_OP(arr, k, m);
        if (ans_op == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans_op);
    }

    private static int roseGarden_OP(int[] arr, int k, int m) {
        // Impossible
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n) return -1;

        // Possible
        int low = Arrays.stream(arr).min().getAsInt();
        int high = Arrays.stream(arr).max().getAsInt();
        int ansDay = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                ansDay = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ansDay; // low will also store answer as it is moving towards possible solution
    }

    private static boolean possible(int[] arr, int day, int m, int k) {
        int count = 0, noOfBookey = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                noOfBookey += (count / k);
                count = 0;
            }
        }
        noOfBookey += (count / k);
        if (noOfBookey >= m) return true;
        return false;
    }

    private static int roseGarden_BF(int[] arr, int k, int m) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        for (int i = min; i <= max; i++) {
            if (possible(arr, i, m, k)) {
                return i;
            }
        }
        return -1;
    }
}
