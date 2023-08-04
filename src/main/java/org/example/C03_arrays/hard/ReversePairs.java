package org.example.C03_arrays.hard;

import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {
        int arr[] = {40, 20, 10};
        reversePairsBF(arr);
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }

    private static void reversePairsBF(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    private static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1, count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }
}
