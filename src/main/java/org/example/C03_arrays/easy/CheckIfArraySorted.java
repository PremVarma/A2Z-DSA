package org.example.C03_arrays.easy;

public class CheckIfArraySorted {
    public static void main(String[] args) {
        int arr[] = {1,2,5,7};
        System.out.println(checkIfArrayIsSorted(arr));
    }

    private static boolean checkIfArrayIsSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]<= arr[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
