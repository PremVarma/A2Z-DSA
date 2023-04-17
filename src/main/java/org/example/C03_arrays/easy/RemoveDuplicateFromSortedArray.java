package org.example.C03_arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,7,5,5};
        int sizeOfUniqueArray = removeDuplicate(arr);
        System.out.println(sizeOfUniqueArray);
        System.out.println(Arrays.toString(arr));
//        Brute force take set and add element to it;
    }


    private static int removeDuplicate(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j]!=arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
}
