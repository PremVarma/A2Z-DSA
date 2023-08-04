package org.example.C03_arrays.medium;

import java.util.Arrays;

public class RotateMatrixImageBy90 {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.deepToString(solution_BF(arr,4,4)));
       // System.out.println(Arrays.deepToString(solution_OP(arr,4,4))); // Transpose matrix ( row->column, colun->row)
    }

    private static int[][] solution_OP(int[][] arr, int n, int m) {
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < m; j++) {
                if(i!=j){
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        // Reverse Matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
        return arr;
    }

    private static int[][] solution_BF(int[][] arr, int n, int m) {
        int result[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n-1-i] = arr[i][j];
            }
        }
        return result;
    }
}
