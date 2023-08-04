package org.example.C04_binary_search.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedSortedArrayI {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int n = 9, k = 8;
        int ans = search(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }

    public static int search(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
