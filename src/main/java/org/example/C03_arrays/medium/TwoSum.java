package org.example.C03_arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2,6,5,8,11};
        int target = 16;
        System.out.println(Arrays.toString(findTwoSum_BT(arr,target))); // Optimal for returning index T(nlogn) S(n)
        System.out.println(Arrays.toString(findTwoSum_OP(arr,target))); // Only for Yes and NO T(nlogn) S(1)  ---> for index S(n)
    }

    private static int[] findTwoSum_OP(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]>target){
                right--;
            }else if(arr[left]+arr[right]<target){
                left++;
            }else{
                return new int[]{arr[left],arr[right]};
            }
        }
        return new int[]{-1,-1};
    }

    private static int[] findTwoSum_BT(int[] arr, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(target-arr[i])){
                return new int[]{hashMap.get(target - arr[i]), i};
            }else{
                hashMap.put(arr[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
