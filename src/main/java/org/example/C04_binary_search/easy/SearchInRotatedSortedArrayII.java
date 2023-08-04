package org.example.C04_binary_search.easy;

// Contains Duplicate
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 1;
        boolean ans = search(arr, k);
        if (ans)
            System.out.println("Target is present.");
        else
            System.out.println("Target is not present.");
    }

    public static boolean search(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }
            if (arr[mid] == k) {
                return true;
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
        return false;
    }
}
