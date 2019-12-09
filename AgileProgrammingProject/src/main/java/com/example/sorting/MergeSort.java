package com.example.sorting;

public class MergeSort {

    public void merge(int[] arr, int l, int m, int r)
    {
        //find size of subbarrays to be merged
        int sizeLeft = m - l + 1;
        int sizeRight = r - m;
        
        //create temp subarrays
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];
        
        //copy data to temp arrays
        for (int i = 0; i < sizeLeft; ++i)
        {
            tempLeft[i] = arr[l + i];
        }
        for (int j = 0; j < sizeRight; ++j)
        {
            tempRight[j] = arr[m + 1 + j];
        }
        
        /* merge */
        int initialIndexLeft = 0;
        int initialIndexRight = 0;
        
        int initialIndexMerged = l;
        
        while (initialIndexLeft < sizeLeft && initialIndexRight < sizeRight)
        {
            if (tempLeft[initialIndexLeft] <= tempRight[initialIndexRight])
            {
                arr[initialIndexMerged] = tempLeft[initialIndexLeft];
                initialIndexLeft++;
            }
            else
            {
                arr[initialIndexMerged] = tempRight[initialIndexRight];
                initialIndexRight++;
            }
            initialIndexMerged++;
        }
        
        //copy remaining
        while (initialIndexLeft < sizeLeft)
        {
            arr[initialIndexMerged] = tempLeft[initialIndexLeft];
            initialIndexLeft++;
            initialIndexMerged++;
        }
        while (initialIndexRight < sizeRight)
        {
            arr[initialIndexMerged] = tempRight[initialIndexRight];
            initialIndexRight++;
            initialIndexMerged++;
        }
    }
    
    public void sort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            //middle point
            int m = (l + r)/2;
            
            //sort first and second halves
            sort(arr, l, m);
            sort(arr, m+1, r);
            
            //merge sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static void main(String[] args) {
        
        int[] array = { 4, 2, 10, 22 };
        int n = array.length;
        
        MergeSort ob = new MergeSort();
        ob.sort(array, 0, n - 1);
        
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
        
    }
}
