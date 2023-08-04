package org.example.C04_binary_search.easy;

public class SearchIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 8;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
    }

    public static int searchInsert(int[] arr, int x) {
        int n = arr.length; // size of the array
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
