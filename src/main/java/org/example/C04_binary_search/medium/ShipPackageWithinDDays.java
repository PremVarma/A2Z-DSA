package org.example.C04_binary_search.medium;

public class ShipPackageWithinDDays {
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = leastWeightCapacity_BF(weights, d);
        int ans_op = leastWeightCapacity_OP(weights, d);
        System.out.println("The minimum capacity should be: " + ans_op);
    }

    private static int leastWeightCapacity_OP(int[] weights, int d) {
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }
        int low = maxi, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (findDays(weights, mid) <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int leastWeightCapacity_BF(int[] weights, int d) {
        //Find the maximum and the summation:
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }

        for (int i = maxi; i <= sum; i++) {
            if (findDays(weights, i) <= d) {
                return i;
            }
        }
        return -1;
    }

    private static int findDays(int[] weights, int capacity) {
        int days = 1; //First day.
        int load = 0;
        int n = weights.length;
        for (int j = 0; j < n; j++) {
            if (load + weights[j] > capacity) {
                days += 1;
                load = weights[j];
            } else {
                load += weights[j];
            }
        }
        return days;
    }
}
