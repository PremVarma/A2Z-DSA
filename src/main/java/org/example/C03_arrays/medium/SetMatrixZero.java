package org.example.C03_arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

//        ArrayList<ArrayList<Integer>> ans_BF = zeroMatrix_BF(matrix, n, m);
//        System.out.println(ans_BF);
//        ArrayList<ArrayList<Integer>> ans_BT = zeroMatrix_BT(matrix, n, m);
//        System.out.println(ans_BT);
        ArrayList<ArrayList<Integer>> ans_OP = zeroMatrix_OP(matrix, n, m);
        System.out.println(ans_OP);
    }

    private static ArrayList<ArrayList<Integer>> zeroMatrix_OP(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
//        int[] row = new int[n]; // row array -> matrix[...][0]
//        int[] col = new int[m]; // col array -> matrix[0][...]
        int col = 1;

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                // Mark The ith row
                    matrix.get(i).set(0,0);
//                    Mark jth column
                    // For first element j should be separte column in variable
                    if(j!=0){
                        matrix.get(0).set(j,0);
                    }else{
                        col = 0;
                    }

                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    //check for column
                    if(matrix.get(0).get(j)==0 || matrix.get(i).get(0)==0){
                        matrix.get(i).set(j,0);
                    }

                }
            }
        }

        if(matrix.get(0).get(0)==0){
            for (int i = 0; i < m; i++) {
                matrix.get(0).set(i,0);
            }
        }

        if(col==0){
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0,0);
            }
        }
        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> zeroMatrix_BT(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> zeroMatrix_BF(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix.get(i).get(j)==0){
                    markRowZero(matrix,i,m);
                    markColumnZero(matrix,j,n);
                }
            }
        }

        // Finally, mark all -1 as 0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    private static void markColumnZero(ArrayList<ArrayList<Integer>> matrix, int x, int n) {
        for (int i = 0; i < n; i++) {
            if(matrix.get(i).get(x)!=0){
                matrix.get(i).set(x,-1);
            }
        }
    }

    private static void markRowZero(ArrayList<ArrayList<Integer>> matrix, int x, int m) {
        for (int i = 0; i < m; i++) {
            if(matrix.get(x).get(i) != 0){
                matrix.get(x).set(i,-1);
            }
        }
    }
}
