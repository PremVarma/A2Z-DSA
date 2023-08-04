package org.example.C03_arrays.medium;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 8, 6, 9};
        solution(arr);
        String s = "-+12";
        System.out.println(atoi(s));
    }

    private static int atoi(String s) {
        double num = 0;
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        boolean negative = s.charAt(0) == '-';
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num *= 10;
                num += (s.charAt(i) - '0');
            }else if(s.charAt(0)=='-' || s.charAt(i)=='+'){
                continue;
            }else{
                break;
            }
        }
        if (negative) {
            num *= -1;
        }
        num = (num>Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num<Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
        return (int) num;
    }

    private static void solution(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            cost += first + second;
            pq.add(first + second);
        }
        System.out.println(cost);
    }
}
