package com.company;

public class ShellSort {

    public static void sort(int[] array) {
        int arrayLength = array.length; //10
        for (int gap = arrayLength / 2; gap > 0; gap /= 2){  // gap=5
            for (int i = gap; i < arrayLength; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,39,31,10,2,1,8,12,4};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
