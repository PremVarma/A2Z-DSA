package org.example.C03_arrays.medium;

public class GroupSameElementsTogether {

    public static void main(String[] args) {
        int[] inputArray = {11, 11, 8, 8, 8, 8, 13, 13, 13, 16, 16, 16};
        countConsecutiveOccurrences(inputArray);
    }

    public static void countConsecutiveOccurrences(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int currentNumber = arr[0];
        int currentCount = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == currentNumber) {
                currentCount++;
            } else {
                System.out.println(currentNumber + ":" + currentCount);
                currentNumber = arr[i];
                currentCount = 1;
            }
        }

        // Print the last element's count
        System.out.println(currentNumber + ":" + currentCount);
    }
}
