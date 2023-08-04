package org.example.C04_binary_search.easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 17;
        int ind = binarySearch(a, target);
        System.out.println(recursiveBinarySearch(a,0,a.length-1,19));
        System.out.println(ind);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] < target) {
            return recursiveBinarySearch(arr, mid + 1, high, target);
        } else if (arr[mid] > target) {
            return recursiveBinarySearch(arr, low, mid - 1, target);
        } else {
            return mid;
        }
    }
}
