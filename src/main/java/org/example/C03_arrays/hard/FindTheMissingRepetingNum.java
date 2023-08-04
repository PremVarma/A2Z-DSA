package org.example.C03_arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class FindTheMissingRepetingNum {
    public static void main(String[] args) {
        int arr[] = {4, 3, 6, 2, 1, 1};
//        missingRepBT(arr);
//        missingRepOP1(arr);
        missingRepOP2(arr);
    }

    private static void missingRepOP2(int[] arr) {
        int xr = 0;
        for (int i = 0; i < arr.length; i++) {
            xr = xr ^ arr[i];
            xr = xr ^ (i + 1);
        }
        // Next block can be number = xr & ~(xr-1)
        int bitNo = 0;
        while (true) {
            if ((xr & (1 << bitNo)) != 0) {
                break;
            }
            bitNo++;
        }
        int one = 0, zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & (1 << bitNo)) != 0) {
                one = one ^ arr[i];
            } else {
                zero = zero ^ arr[i];
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if ((i & (1 << bitNo)) != 0) {
                one = one ^ i;
            } else {
                zero = zero ^ i;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == zero) count++;
        }
        if (count == 2) System.out.println("Repeat " + zero + " ,Missing " + one);
        else System.out.println("Repeat " + one + " ,Missing " + zero);

    }

    private static void missingRepOP1(int[] arr) {
        int n = arr.length;
        int sumOfNum = n * (n + 1) / 2;
        int sumOfNumSquqre = (n * (n + 1) * (2 * n + 1)) / 6;
        int sumOfArray = 0, sumOfSquareArray = 0;
        for (int i = 0; i < n; i++) {
            sumOfArray += arr[i];
            sumOfSquareArray += arr[i] * arr[i];
        }
        int value1 = sumOfNum - sumOfArray; // x-y
        int value2 = sumOfNumSquqre - sumOfSquareArray; // x^2 - y^2
        value2 = value2 / value1; //x+y
        int x = (value1 + value2) / 2;
        int y = x - value1;
        System.out.println(x + ", " + y);
    }

    private static void missingRepBT(int[] arr) {
        int[] substitute = new int[arr.length + 1];
        // initializing the substitute array with 0 of size n+1.
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length + 1; i++) {
            substitute[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            substitute[arr[i]]++;
        }

        for (int i = 1; i <= arr.length; i++) {
            if (substitute[i] == 0 || substitute[i] > 1) {
                ans.add(i);
            }
        }
        System.out.println(ans);
    }
}
