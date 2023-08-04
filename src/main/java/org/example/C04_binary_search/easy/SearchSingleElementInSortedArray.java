package org.example.C04_binary_search.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchSingleElementInSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr =
                new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));
        int ans = singleNonDuplicateOP(arr);
        System.out.println("The single element is: " + ans);
    }

    public static int singleNonDuplicateBF(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of the array.
        if (n == 1)
            return arr.get(0);

        for (int i = 0; i < n; i++) {
            // Check for first index:
            if (i == 0) {
                if (!arr.get(i).equals(arr.get(i + 1)))
                    return arr.get(i);
            }
            // Check for last index:
            else if (i == n - 1) {
                if (!arr.get(i).equals(arr.get(i - 1)))
                    return arr.get(i);
            } else {
                if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1)))
                    return arr.get(i);
            }
        }

        // Dummy return statement:
        return -1;
    }

    public static int singleNonDuplicateBF2(ArrayList<Integer> arr) {
        int n = arr.size(); //size of the array.
        int ans = 0;
        // XOR all the elements:
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr.get(i);
        }
        return ans;
    }

    public static int singleNonDuplicateOP(ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        if (arr.size() == 1) return arr.get(0);
        if (arr.get(0) != arr.get(1)) return arr.get(0);
        if (arr.get(arr.size() - 1) != arr.get(arr.size() - 2)) return arr.get(arr.size() - 1);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) != arr.get(mid + 1) && arr.get(mid) != arr.get(mid - 1)) {
                return arr.get(mid);
            }
            if (mid % 2 == 1 && arr.get(mid - 1) == arr.get(mid) || mid % 2 == 0 && arr.get(mid) == arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
