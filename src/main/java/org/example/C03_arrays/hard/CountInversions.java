package org.example.C03_arrays.hard;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = {6, 2, 5};
        countInversionBF(arr);
        countInversionOP(arr);
    }

    private static void countInversionOP(int[] arr) {
        System.out.println(mergeSort(arr,0,arr.length-1));
    }

    private static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    private static int merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                count += (mid - left + 1);
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
        return count;
    }

    private static void countInversionBF(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
