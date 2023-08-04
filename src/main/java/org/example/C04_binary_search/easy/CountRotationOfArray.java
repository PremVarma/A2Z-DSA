package org.example.C04_binary_search.easy;

public class CountRotationOfArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1};
        int ans = findKRotationBF(arr);
        System.out.println("The array is rotated " + ans + " times.");
        int ans1 = findKRotationOP(arr);
        System.out.println("The array is rotated " + ans1 + " times.");

    }

    private static int findKRotationOP(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                // Eliminate left half:
                low = mid + 1;
            } else { //if right part is sorted:

                // keep the minimum:
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }

    private static int findKRotationBF(int[] arr) {
        int ans = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
                index = i;
            }
        }
        return index;
    }
}
