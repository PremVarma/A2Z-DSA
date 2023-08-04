package org.example.C03_arrays.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FourSum {
    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 0, 2, -2};
        solution_BT(arr, 0);
        solution_OP(arr, 0);
    }

    private static void solution_OP(int[] arr, int target) {
        Set<int[]> resultSet = new TreeSet<>(Arrays::compare);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        int sortedElements[] = new int[]{arr[i], arr[j], arr[k], arr[l]};
                        resultSet.add(sortedElements);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        for (int[] element : resultSet) {
            System.out.println(Arrays.toString(element));
        }
    }

    private static void solution_BT(int[] arr, int target) {
        Set<int[]> resultSet = new TreeSet<>(Arrays::compare);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < arr.length; k++) {
                    int forth = target - (arr[i] + arr[j] + arr[k]);
                    if (set.contains(forth)) {
                        int sortedElements[] = new int[]{arr[i], arr[j], arr[k], forth};
                        Arrays.sort(sortedElements);
                        resultSet.add(sortedElements);
                    }
                    set.add(arr[k]);
                }
            }
        }
        for (int[] element : resultSet) {
            System.out.println(Arrays.toString(element));
        }
    }
}
