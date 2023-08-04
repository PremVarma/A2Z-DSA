package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 2, -4, -5, 3, 4};
        solution(arr);
    }


    private static void solution(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }
        if (pos.size() < neg.size()) {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }else{
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static ArrayList<ArrayList<String>> getGroups(ArrayList<String> inputData) {
        ArrayList<ArrayList<String>> groups = new ArrayList<>();

        HashMap<Integer, ArrayList<String>> map = new HashMap();
        for (int i = 0; i < inputData.size(); i++) {
            if (map.get(inputData.get(i).length()) == null) {
                ArrayList<String> subGroup = new ArrayList<>();
                subGroup.add(inputData.get(i));
                map.put(inputData.get(i).length(), subGroup);
            } else {
                map.get(inputData.get(i).length()).add(inputData.get(i));
            }
        }
        for (Map.Entry<Integer, ArrayList<String>> subGroups : map.entrySet()) {
            groups.add(subGroups.getValue());
        }
        return groups;
    }
}
