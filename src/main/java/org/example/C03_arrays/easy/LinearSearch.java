package org.example.C03_arrays.easy;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,6,7};
        int findNum = 6;
        System.out.println(search(arr,findNum));
    }

    private static int search(int[] arr, int findNum) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] ==findNum){
                return i;
            }
        }
        return -1;
    }
}
