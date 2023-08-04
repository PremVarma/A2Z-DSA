package org.example.C04_binary_search.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookAllocationProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25,46,28,49,24));
        int n = arr.size();
        int m = 4;
        int ans = findPages_BF(arr, n, m);
        int ans_op = findPages_OP(arr, n, m);
        System.out.println("The answer is: " + ans_op);
    }

    private static int findPages_OP(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int cntStudents = countStudent(arr, mid);
            if (cntStudents < m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findPages_BF(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int max = Collections.max(arr);
        int totalPages = arr.stream().mapToInt(Integer::intValue).sum();
        for (int i = 0; i < arr.size(); i++) {
            totalPages += arr.get(i);
            max = Math.max(max, arr.get(i));
        }
        for (int i = max; i <= totalPages; i++) {
            int cntStudents = countStudent(arr, i);
            if (cntStudents == m) return i;
        }
        return max;
    }

    private static int countStudent(ArrayList<Integer> arr, int pages) {
        int noStudent = 1, noOfPages = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (noOfPages + arr.get(i) <= pages) {
                noOfPages += arr.get(i);
            } else {
                noStudent++;
                noOfPages = arr.get(i);
            }
        }
        return noStudent;
    }


}
