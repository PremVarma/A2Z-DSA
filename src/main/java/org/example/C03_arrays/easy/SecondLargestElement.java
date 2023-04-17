package org.example.C03_arrays.easy;

import java.util.Arrays;

    public class SecondLargestElement {
        public static void main(String[] args) {
            int arr[] = {2,14,4,1,2,12,14,14,13,0};
            System.out.println(largestBruteElement(arr,14));
            int secondLarge = secondOptimalLargest(arr);
            int secondSmall = secondOptimalSmallest(arr);
            System.out.println(secondLarge+","+secondSmall);
        }

        private static int secondOptimalSmallest(int[] arr) {
            int smallest = arr[0],secondSmallest = -1;
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]<smallest){
                    secondSmallest = smallest;
                    smallest = arr[i];
                }else if(arr[i]!=smallest && arr[i]<secondSmallest){
                    secondSmallest = arr[i];
                }
            }
            return secondSmallest;
        }

        private static int secondOptimalLargest(int[] arr) {
            int largest = arr[0],secondLargest = -1;
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]>largest){
                    secondLargest = largest;
                    largest = arr[i];
                }else if(arr[i]<largest && arr[i]>secondLargest){
                    secondLargest = arr[i];
                }
            }
            return secondLargest;
        }


        private static int largestBruteElement(int[] arr,int largest) {
            int secondLargest = -1;
            for(int i=0;i<=arr.length-1;i++){
                if(arr[i]!=largest && arr[i]>secondLargest){
                    secondLargest =  arr[i];
                }
            }
            return secondLargest;
        }
    }
