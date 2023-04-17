package org.example.C03_arrays.easy;

public class LongestSubarrayWithSumPositiveOnly {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,1,4,2,3};
        int matchSum = 5;
        System.out.println(solution(arr,matchSum));
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
