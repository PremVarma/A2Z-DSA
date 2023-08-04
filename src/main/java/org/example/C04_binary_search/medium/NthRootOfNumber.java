package org.example.C04_binary_search.medium;

public class NthRootOfNumber {
    public static void main(String[] args) {
        int N = 4, M = 625;
        System.out.println(NthRootOP(N, M));
    }

    public static long func(int b, int exp) { // Power Exponential Method
        long ans = 1;
        long base = b;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans = ans * base;
            } else {
                exp /= 2;
                base = base * base;
            }
        }
        return ans;
    }

    public static int NthRootBF(int n, int m) {
        //Use linear search on the answer space:
        for (int i = 1; i <= m; i++) {
            long val = func(i, n);
            if (val == (long) m) return i;
            else if (val > (long) m) break;
        }
        return -1;
    }

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public static int NthRootOP(int n, int m) {
        // Use binary search on the answer space:
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
