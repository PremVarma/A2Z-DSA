package org.example.C03_arrays.easy;

public class MaximumConsucutiveOne {
    public static void main(String[] args) {
        int arr[] = {1,1,0,1,1,1,0,1,1};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int max1s = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                counter+=1;
            }else{
                max1s = Math.max(max1s,counter);
                counter = 0;
            }
        }
        return max1s;
    }
}
