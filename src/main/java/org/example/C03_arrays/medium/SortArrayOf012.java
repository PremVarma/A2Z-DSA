package org.example.C03_arrays.medium;

import java.util.Arrays;

public class SortArrayOf012 {
    public static void main(String[] args) {
        int arr[] = {1,1,2,0,0};
        sortNumbers_BT(arr);
        sortNumbers_OP(arr); //Dutch National Flag Algo
    }

    private static void sortNumbers_OP(int[] arr) {
        int low = 0,mid = 0,high = arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(arr,mid,high);
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void sortNumbers_BT(int[] arr) {
        int count_0 = 0,count_1 = 0,count_2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                count_0++;
            }else if(arr[i]==1){
                count_1++;
            }
        }
        for (int i = 0; i < count_0; i++) {
            arr[i] = 0;
        }
        for (int i = count_0; i <count_0 + count_1; i++) {
            arr[i] = 1;
        }
        for (int i = count_0 + count_1; i < arr.length; i++) {
            arr[i] = 2;
        }
        System.out.println(Arrays.toString(arr));
    }


    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
