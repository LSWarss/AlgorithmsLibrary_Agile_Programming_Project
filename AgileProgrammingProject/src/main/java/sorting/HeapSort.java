/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author pc
 */
public class HeapSort {
    
    public void sort(int arr[])
    {
        int n = arr.length;
        
        // build heap
        for (int i = n / 2 - 1; i>=0; i--)
            heapify(arr, n, i);
        
        // one by one extract an element from hep
        for (int i = n - 1; i >= 0; i--)
        {
            // move cuttent root to end 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int[] arr, int n, int i)
    {
        int largest = i; //initialize largest as root
        int l = 2*i + 1; //left child
        int r = 2*i + 2; //right child
        
        // if left child is larger than largest so far
        if (l < n && arr[l] > arr[largest])
            largest = l;
        
        // if right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
        
        // if largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            //recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = { 65, 2, 22, 10, 6 };
        int n = arr.length;
        
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    
}
