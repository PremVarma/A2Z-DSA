package org.example.C04_binary_search.medium;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows_BF(stalls, k);
        int ans_op = aggressiveCows_OP(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans_op);
    }

    private static boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCows = 1, last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];
            }
        }
        return cntCows >= cows;
    }

    private static int aggressiveCows_OP(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = stalls[0];
        int high = stalls[stalls.length - 1] - stalls[0], ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static int aggressiveCows_BF(int[] stalls, int k) {
        Arrays.sort(stalls);
        int limit = stalls[stalls.length - 1] - stalls[0];
        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(stalls, i, k)) {
                return (i - 1);
            }
        }
        return limit;
    }
}
