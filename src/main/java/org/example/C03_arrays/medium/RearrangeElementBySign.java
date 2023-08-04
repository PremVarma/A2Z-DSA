package org.example.C03_arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeElementBySign {
    public static void main(String[] args) {
        int arr[] = {3,1,-2,-5,2,-4};
        int nonEqArr[] = {1,2,-4,-5,-3,6};
        solution_BF(arr); // eqaul + and -
        solution_OP(arr); // equal + and -
        solution_OP_NE(nonEqArr); // not equal + and -
    }

    private static void solution_OP_NE(int[] arr) {
        ArrayList<Integer> positive =  new ArrayList<>();
        ArrayList<Integer> negative =  new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                positive.add(arr[i]);
            }else{
                negative.add(arr[i]);
            }
        }

        if(positive.size() > negative.size()){
            for (int i = 0; i < negative.size(); i++) {
                arr[2*i+1] = negative.get(i);
                arr[2*i] = positive.get(i);
            }

            int index  = negative.size()*2;
            for (int i = negative.size(); i < positive.size(); i++) {
                arr[index] = positive.get(i);
                index++;
            }
        }else{
            for (int i = 0; i < positive.size(); i++) {
                arr[2*i+1] = negative.get(i);
                arr[2*i] = positive.get(i);
            }

            int index  = positive.size()*2;
            for (int i = positive.size(); i < negative.size(); i++) {
                arr[index] = negative.get(i);
                index++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void solution_OP(int[] arr) {
        int ans[] = new int[arr.length];
        int pos = 0,neg = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                ans[neg] = arr[i];
                neg+=2;
            }else{
                ans[pos] = arr[i];
                pos+=2;
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    private static void solution_BF(int[] arr) {
        
        ArrayList<Integer> positive =  new ArrayList<>();
        ArrayList<Integer> negative =  new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                positive.add(arr[i]);
            }else{
                negative.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length/2; i++) {
            arr[i*2] = positive.get(i);
            arr[i*2+1] = negative.get(i);
        }

        System.out.println(Arrays.toString(arr));
    }
}
