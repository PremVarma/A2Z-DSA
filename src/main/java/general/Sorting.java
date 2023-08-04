package general;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        solution(arr);
    }


    public static void solution(int[][] arr) {
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            } else if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortInsertion(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int arr[], int low, int high) {
        int i = low, j = high, pivot = arr[low];
        while (i < j) {
            while (arr[i] <= pivot && i < high) i++;
            while (arr[j] > pivot && j >= low) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    private static void merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
