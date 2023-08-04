package org.example.C03_arrays.hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, -4};
        solution_BF(arr, 0);
        solution_BT(arr, 0);
        solution_OP(arr, 0);
    }

    private static void solution_OP(int[] arr, int target) {
        Arrays.sort(arr);
        Set<int[]> resultSet = new TreeSet<>(Arrays::compare);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = arr.length - 1;
            while(j<k){
                int sum = arr[i] + arr[j] +arr[k];
                if(sum<target){
                    j++;
                }else if(sum>target){
                    k--;
                }else{
                    int sortedElements[] = new int[]{arr[i], arr[j], arr[k]};
                    resultSet.add(sortedElements);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1]) j++;
                    while(j<k && arr[k]==arr[k+1]) k--;
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
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int third = target - (arr[i] + arr[j]);
                if (set.contains(third)) {
                    int sortedElements[] = new int[]{arr[i], arr[j], third};
                    Arrays.sort(sortedElements);
                    resultSet.add(sortedElements);
                }
                set.add(arr[j]);
            }
        }
        for (int[] element : resultSet) {
            System.out.println(Arrays.toString(element));
        }
    }

    private static void solution_BF(int[] arr, int target) {
        Set<int[]> set = new TreeSet<>(Arrays::compare);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        int sortedElements[] = new int[]{arr[i], arr[j], arr[k]};
                        Arrays.sort(sortedElements);
                        set.add(sortedElements);
                    }
                }
            }
        }
        for (int[] element : set) {
            System.out.println(Arrays.toString(element));
        }
    }
}
