package org.example.C04_binary_search.medium;

public class SqrtNumberUsingBS {
    public static void main(String[] args) {
        int number = 49;
        int res = findSqrt(number);
        System.out.println("Sqrt of " + number + " is " + res);
    }

    public static int findSqrt(int num) {
        int low = 1, high = num, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= num) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans; // high also stores the answer (intuition)
    }
}
