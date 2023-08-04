package org.example.C04_binary_search.easy;

public class LastOccuranceIndex {
    public static void main(String[] args) {
        int n = 8;
        int key = 40;
        int[] v = {3, 4, 13, 13, 13, 20, 40, 40};

        // returning the last occurrence index if the element is present otherwise -1
        System.out.println(solve(n, key, v));
    }

    private static int solve(int n, int key, int[] v) {
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == v[mid]) {
                ans = mid;
                low = mid + 1;
            } else if (key < v[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
