/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import node.Node;

/**
 *
 * @author pc
 */
public class HeapSort extends AbstractSorting {
    
    private static final Color ROOT_COLOR = Color.GOLD;
    private ArrayList<Transition> transitions = new ArrayList<>();
    
    public void sort(Node[] arr)
    {
        transitions.add(colorCNode(selectSubTree(arr, arr.length), SELECT_COLOR));
        
        // build heap
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);
	
	transitions.add(colorCNode(selectSubTree(arr, arr.length), START_COLOR));
        
        // one by one extract an element from hep
        for (int i = arr.length - 1; i > 0; i--)
        {
            // move cuttent root to end 
            transitions.add(colorCNode(arr, ROOT_COLOR, 0));
	    transitions.add(swap(arr, 0, i));
	    transitions.add(colorCNode(arr, START_COLOR, i));
	    transitions.add(colorCNode(selectSubTree(arr, i), SELECT_COLOR));
            
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
	    
	    transitions.add(colorCNode(selectSubTree(arr, i), START_COLOR));
        }
    }
    
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(Node[] arr, int n, int i)
    {
        int largest = i; //initialize largest as root
        int l = 2*i + 1; //left child
        int r = 2*i + 2; //right child
        
        // if left child is larger than largest so far
        if (l < n && arr[l].getValue() > arr[largest].getValue())
            largest = l;
        
        // if right child is larger than largest so far
        if (r < n && arr[r].getValue() > arr[largest].getValue())
            largest = r;
        
        // if largest is not root
        if (largest != i)
        {
            transitions.add(swap(arr, i, largest));
            
            //recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    private ArrayList<Node> selectSubTree(Node[] arr, int n) {
	ArrayList<Node> list = new ArrayList<>();

	for (int i = 0; i < n; i++) {
	  list.add(arr[i]);
	}

	return list;
    }
    
    @Override
    public ArrayList<Transition> startSort(Node[] array) {
	sort(array);
	
        transitions.add(colorCNode(Arrays.asList(array), Color.ROYALBLUE));
	
        return transitions;
    }
    
}
