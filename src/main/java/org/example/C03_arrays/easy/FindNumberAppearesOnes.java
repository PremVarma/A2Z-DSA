package org.example.C03_arrays.easy;

public class FindNumberAppearesOnes {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,3,4,4};
        // brute search -> linear search using two nested loops
        // better solution -> hashing (array of size of max of arr ex 4)
        //optimal
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int findResult = 0;
        for (int i = 0; i < arr.length; i++) {
            findResult^=arr[i];
        }
        return findResult;
    }
}
