package org.example.C04_binary_search.easy;

public class PeakElementInArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 10, 8, 6, 5};
        int index = findPeakOP(arr);
        System.out.println(index);
    }

    private static int findPeakBF(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((i == 0 || arr[i] > arr[i - 1]) && (i == arr.length - 1 || arr[i] > arr[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    private static int findPeakOP(int[] arr) {
        // Edge cases:
        if (arr.length == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
