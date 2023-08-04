package org.example.C03_arrays.hard;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args) {
        // Given row and column find the element of that place nCr => n!/r!*(n-r)!
        int row = 6, column = 3;
        findElement(row-1,column-1);
        // Print nth row of pascal triangle
        printRowOfPascalTriangle(row-1);
        // Print pascal triangle
        printPascalTriangle(row);
    }

    private static void printPascalTriangle(int row) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            list.add(generateRow(i));
        }
        System.out.println(list);
    }

    private static ArrayList<Integer> generateRow(int row){
         int ans = 1;
         ArrayList<Integer> ansRow =  new ArrayList<>();
         ansRow.add(1);
        for (int col = 1; col < row; col++) { // last value wil always be 1
            ans = ans * (row-col) / col;
            ansRow.add(ans);
        }
        return ansRow;
    }

    private static void printRowOfPascalTriangle(int n) {
        int ans =1;
        System.out.println(ans);
        for (int c = 1; c < n ; c++) {
            ans = ans * (n-c) / c;
            System.out.println(ans);
        }
    }

    private static int findElement(int n,int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res*=(n-i);
            res/=(i+1);
        }
        System.out.println(res);
        return res;
    }
}
