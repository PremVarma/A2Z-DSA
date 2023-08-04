package org.example.C03_arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {
    public static void main(String[] args) {
        int arr[] = {102,4,100,1,101,3,2,1,1,5};
        solution_BF(arr); // T(N^2)
        solutionBT(arr); // T(NlognN)
        solution_OP(arr);
    }

    private static void solution_OP(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        } // T(N)

        int longestStreak = 0;

        for (int num: nums) { // T(2N)
            if (!hashSet.contains(num - 1)) { //We should start from the point which is minimum for that sequene like 1,2,3,4 in this case if we get 1 then only we shoyld start else not
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        System.out.println(longestStreak);
    }

    private static void solutionBT(int[] arr) {
        Arrays.sort(arr);
        int longest = 1;
        int prevElement = arr[0];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==prevElement+1){
                count+=1;
                prevElement = arr[i];
            }
            else if(arr[i]!=prevElement+1){
                count=1;
                prevElement = arr[i];
            }
            longest = Math.max(longest,count);
        }
        System.out.println("Longest "+longest);
    }

    private static void solution_BF(int[] arr) {
        int longestSequence = 1;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int count = 1;
            while(findElement(arr,x+1)){
                x+=1;
                count+=1;
            }
            longestSequence = Math.max(longestSequence,count);
        }
        System.out.println(longestSequence);
    }

    private static boolean findElement(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==x){
                return true;
            }
        }
        return false;
    }
}
