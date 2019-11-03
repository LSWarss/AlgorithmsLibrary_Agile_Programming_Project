package com.company;

public class Main {

    public static void main(String[] args) {

        int[] testArray = {10, 12, -4 , 5 , 20, 30};
        quickSort.Sort(testArray,0,testArray.length-1);
        Utility.PrintArray(testArray);

    }
}
