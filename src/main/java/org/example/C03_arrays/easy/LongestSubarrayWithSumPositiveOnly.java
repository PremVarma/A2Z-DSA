package org.example.C03_arrays.easy;

import java.util.HashMap;

public class LongestSubarrayWithSumPositiveOnly {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,3,3};
        int matchSum = 6;
        System.out.println(solution(arr,matchSum)); // Fail in case of 0,0
        System.out.println(longestSubArrWithSumK_BF(arr,arr.length,matchSum));
        System.out.println(longestSubArrWithSumK_Better(arr,arr.length,matchSum)); // Will be optimal and accepted in case where we have negative values also
        System.out.println(longestSubArrWithSumK_Optimal(arr,arr.length,matchSum)); // Optimal only for positive values and zero
    }

    private static int longestSubArrWithSumK_Optimal(int[] arr, int n, int k) {
        int left = 0,right = 0,sum = arr[0],maxLengh=0;
        while(right<n){
            while(sum>k && left<=right){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLengh = Math.max(maxLengh,right-left+1);
            }
            right++;
            if(right < n && sum<=k) sum+=arr[right];
        }
        return maxLengh;
    }

    private static int longestSubArrWithSumK_Better(int[] arr, int n, int k) {
        HashMap<Integer,Integer> hashMap =  new HashMap<>();
        int maxLen = 0;
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            if(preSum==k){
                maxLen = i+1;
            }
            if(!hashMap.containsKey(preSum)){
                hashMap.put(preSum,i);
            }
            if(hashMap.containsKey(preSum-k)){
                maxLen = Math.max(maxLen,i- hashMap.get(preSum-k));
            }
        }
        return maxLen;
    }

    public static int longestSubArrWithSumK_BF(int[] arr, int n, int k) {
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k)
                    maxLength = Math.max(maxLength, (j - i + 1));
            }

        }
        return maxLength;
    }


    private static int solution(int[] arr,int K) {
        int maxSubarrayLength = 0;
        int sum  = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            counter++;
            if(sum==K){
                maxSubarrayLength = Math.max(counter,maxSubarrayLength);
            }else if(sum>K){
                sum = 0;
                counter = 0;
            }
        }
        return maxSubarrayLength;
    }
}
