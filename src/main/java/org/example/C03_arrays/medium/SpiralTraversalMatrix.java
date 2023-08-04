package org.example.C03_arrays.medium;

import java.util.ArrayList;

public class SpiralTraversalMatrix {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        solution_OP(arr, 4, arr[0].length);

    }

    private static void solution_OP(int[][] arr, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(arr[i][right]);
            }
            right--;
            if (top <= bottom) {  // single row edge case
                for (int i = right; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) { //single row edge case
                for (int i = bottom; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }
        System.out.println(list);
    }
}
