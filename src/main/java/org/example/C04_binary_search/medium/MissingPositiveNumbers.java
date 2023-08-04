package org.example.C04_binary_search.medium;

public class MissingPositiveNumbers {
    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
        int ans = missingK_BF(vec, n, k);
        int ans_op = missingK_OP(vec, n, k);
        System.out.println("The missing number is: " + ans_op);
    }

    private static int missingK_BF(int[] vec, int n, int k) {
        for (int num : vec) {
            if (num <= k) k++;
            else break;
        }
        return k;
    }

    // ans => arr[high]+more ( more => k - missing & missing  = arr[high]-(high+1)
    // ie. arr[high] + k - arr[high] - high + 1 =  high+k+1 or low+k ( low = 1+high )
    private static int missingK_OP(int[] arr, int n, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) low = mid + 1;
            else high = mid - 1;
        }
        return high + 1 + k;
    }
}
