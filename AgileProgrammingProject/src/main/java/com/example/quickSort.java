package com.example;



public class quickSort {

    public static void Sort(int[] array, int low, int high){
        if(low < high) {
            int p = Partition(array, low, high); //this is partitioning index

            //Recursively sort elements before and after partition
            quickSort.Sort(array, low, p -1);
            quickSort.Sort(array, p+1, high);
        }
    } //Description: Main function for implementing quickSort()

    private static int Partition(int[] array, int low, int high){

        int pivot = array[high];
        int i = (low - 1); //index of smaller element
        for(int j = low; j < high; j++){
            if(array[j] < pivot){  //if current element is smaller then the pivot do:
                i++;
                //Swapping array[i] with array[j]
                int tempNumber = array[i];
                array[i] = array[j];
                array[j] = tempNumber;
            }
        }
        //Swap array[i+1] and array[high]
        int tempNumber = array[i+1];
        array[i+1] = array[high];
        array[high] = tempNumber;

        return i+1;

    } //Description: Function takes the last element as pivot, then it places it in sorted array, and then places all smaller then the pivot on the left of the pivot and greater elements on right from the pivot.


}
