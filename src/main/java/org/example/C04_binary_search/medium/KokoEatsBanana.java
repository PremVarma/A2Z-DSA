package org.example.C04_binary_search.medium;

import java.util.Arrays;

public class KokoEatsBanana {
    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananas_OP(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) (v[i]) / (double) (hourly));
        }
        return totalH;
    }

    private static int minimumRateToEatBananas_BP(int[] v, int h) {
        int maxi = Arrays.stream(v).max().getAsInt();
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(v, i);
            if (reqTime <= h) {
                return i;
            }
        }

        //dummy return statement
        return maxi;
    }

    private static int minimumRateToEatBananas_OP(int[] v, int h) {
        int low = 1, high = Arrays.stream(v).max().getAsInt(), ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int reqTime = calculateTotalHours(v, mid);
            if (reqTime <= h) {
                ans = mid;
                high = mid - 1;
            }  else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
