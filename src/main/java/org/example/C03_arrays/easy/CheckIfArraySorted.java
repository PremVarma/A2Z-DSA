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

    public boolean checkIfArrayIsSortedAndRotated(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]>nums[i+1]){
                count++;
            }
        }
        if(nums[nums.length-1]>nums[0]){
            count++;
        }
        return count<=1;
    }
}
