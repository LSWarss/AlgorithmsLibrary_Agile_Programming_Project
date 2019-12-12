package com.example;

public class BubbleSort {
    static void Sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = {10, 12, -4 , 5 , 20, 30};
        Sort(testArray);
        Utility.PrintArray(testArray);
    }
}