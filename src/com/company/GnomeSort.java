package com.company;

public class GnomeSort {
    public void runSort(int[] array) {

        int index = 0;
        while (index < array.length) {
            if (index == 0)
                index++;
            if (array[index] >= array[index - 1])
                index++;
            else {
                int temp = 0;
                temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}
