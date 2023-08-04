package org.example.C03_arrays.medium;

public class TimeToBuyAndSellStock {
    public static void main(String[] args) {
        int arr[] = {7,1,2,3,6,4};
        System.out.println(findProfit(arr));
    }

    private static int findProfit(int[] arr) {
        int profit = 0,min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;
            profit = Math.max(profit,cost);
            min = Math.min(min,arr[i]);
        }
        return profit;
    }
}
