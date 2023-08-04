package org.example.C03_arrays.hard;

import java.util.Arrays;

public class MergeSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
//        mergeBF(arr1,arr2);
//        mergeOP1(arr1,arr2);
        mergeOP2(arr1, arr2); // O(log2(n+m)) * O(n+m)
    }

    private static void mergeOP2(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int gap = (len / 2) + (len % 2); // arr1.length+arr2.length /2 take ceil
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < arr1.length && right >= arr1.length) {
                    swap(arr1, arr2, left, right - arr1.length);
                } else if (left >= arr1.length) {
                    swap(arr2, arr2, left - arr1.length, right - arr1.length);
                } else {
                    swap(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap = (gap/2)+(gap%2);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void swap(int arr1[], int arr2[], int i, int j) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }

    private static void mergeOP1(int[] arr1, int[] arr2) {
        int left = arr1.length - 1, right = 0;
        while (left >= 0 && right < arr2.length) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void mergeBF(int[] arr, int[] arr2) {
        int result[] = new int[arr.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] > arr2[j]) {
                result[k] = arr2[j];
                j++;
            } else {
                result[k] = arr[i];
                i++;
            }
            k++;
        }
        while (i < arr.length) {
            result[k++] = arr[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        for (int l = 0; l < result.length; l++) {
            if (l < arr.length) arr[l] = result[l];
            else arr2[l - arr.length] = result[l];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
