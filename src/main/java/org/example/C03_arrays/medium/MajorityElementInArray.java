package org.example.C03_arrays.medium;

import java.util.HashMap;
import java.util.Map;

//Moore's Voting Algorithm
public class MajorityElementInArray {
    public static void main(String[] args) {
        //Appears more than N/2 time
        int arr[] = {2,2,3,3,1,3,3,2,2,2,2,2};
        System.out.println(majoritySolution_BT(arr));
        System.out.println(majoritySolution_OP(arr));
    }

    //Moore's Voting Algorithm
    private static int majoritySolution_OP(int[] arr) {
        int count = 0;
        int currentElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(count==0){
                count = 1;
                currentElement = arr[i];
            } else if(currentElement == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(currentElement==arr[i]) count++;
        }
        if(count>arr.length / 2){
            return currentElement;
        }
        return -1;
    }

    private static int majoritySolution_BT(int[] arr) {
        HashMap<Integer,Integer> hashMap =  new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            if (it.getValue() > (arr.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
}
