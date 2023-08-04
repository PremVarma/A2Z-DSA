package org.example.C03_arrays.hard;

import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(new Integer[]{1, 3}));
        arr.add(Arrays.asList(new Integer[]{2, 4}));
        arr.add(Arrays.asList(new Integer[]{2, 6}));
        arr.add(Arrays.asList(new Integer[]{8, 9}));
        arr.add(Arrays.asList(new Integer[]{8, 10}));
        arr.add(Arrays.asList(new Integer[]{9, 11}));
        arr.add(Arrays.asList(new Integer[]{15, 18}));
        arr.add(Arrays.asList(new Integer[]{16, 17}));
        bruteForce(arr);
        optimalSolution(arr);
    }

    private static void optimalSolution(ArrayList<List<Integer>> arr) {
        Collections.sort(arr, Comparator.comparingInt(a -> a.get(0)));
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int start = arr.get(i).get(0);
            int end = arr.get(i).get(1);
            if(result.isEmpty() ||  start > result.get(result.size()-1).get(1)){
                result.add(arr.get(i));
            }else{
                result.get(result.size()-1).set(1,Math.max(result.get(result.size()-1).get(1),end));
            }
        }
        System.out.println(result);
    }

    private static void bruteForce(ArrayList<List<Integer>> arr) {
        Collections.sort(arr, Comparator.comparingInt(a -> a.get(0)));
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int start = arr.get(i).get(0);
            int end = arr.get(i).get(1);
            if (!result.isEmpty() && end <= result.get(result.size() - 1).get(1)) {
                continue;
            }
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).get(0) <= end) {
                    end = Math.max(end, arr.get(j).get(1));
                } else {
                    break;
                }
            }
            result.add(Arrays.asList(start, end));
        }
        System.out.println(result);
    }

}
