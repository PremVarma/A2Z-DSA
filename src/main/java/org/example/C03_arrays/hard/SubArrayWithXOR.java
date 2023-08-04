package org.example.C03_arrays.hard;

import java.util.HashMap;

public class SubArrayWithXOR {
    public static void main(String[] args) {
        int arr[] = {4,2,2,6,4};
        int xor = 6;
        bruteForce(arr,xor);
        // x = xr ^ k
        optimal(arr,xor);
    }

    private static void optimal(int[] A, int B) {
        HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
        int c = 0;
        int cpx = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            cpx = cpx ^ A[i];
            if(visited.get(cpx^B) != null)
                c += visited.get(cpx ^ B);
            if(cpx == B) {
                c++;
            }
            visited.put(cpx,visited.getOrDefault(cpx,0)+1);
        }
        System.out.println(c);
    }

    private static void bruteForce(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor^=arr[j];
                if(xor==target){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
