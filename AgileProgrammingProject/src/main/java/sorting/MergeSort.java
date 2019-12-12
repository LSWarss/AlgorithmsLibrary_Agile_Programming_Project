package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import node.Node;

public class MergeSort extends AbstractSorting {

    private Node[] tmp;
    
    private ArrayList<Transition> merge(Node[] arr, int l, int m, int r)
    {
	ArrayList<Transition> transitions = new ArrayList<>();
	List<Node> tmpList = new ArrayList<>();
	
	for (int i = l; i <= r; i++)
	{
	    tmp[i] = arr[i];
	    tmpList.add(tmp[i]);
	}
	
	int i = l;
	int j = m + 1;
	int k = l;
        
        /* merge */
        while (i <= m && j <= r)
	{
	    if (tmp[i].getValue() <= tmp[j].getValue())
	    {
		arr[k++] = tmp[i++];
	    }
	    else
	    {
		arr[k++] = tmp[j++];
	    }
	}
        
        //copy remaining
        while (i <= m)
	{
	    arr[k++] = tmp[i++];
	}
        while (j <= r)
	{
	    arr[k++] = tmp[j++];
	}
	
	transitions.add(colorCNode(tmpList, SELECT_COLOR));
	
	ParallelTransition pt = new ParallelTransition();
	
	for (int x = l; x <= r; x++)
	{
	    for (int y = l; y <= r; y++)
	    {
		if (tmp[x].equals(arr[y]))
		{
		    pt.getChildren().add(tmp[x].moveX(DX * (y - x)));
		}
	    }
	}
	
	transitions.add(pt);
	transitions.add(colorCNode(tmpList, SELECT_COLOR));
	
	return transitions;
    }
    
    private ArrayList<Transition> sort(Node[] arr, int l, int r)
    {
	ArrayList<Transition> transitions = new ArrayList<>();
	
        if (l < r)
        {
            //middle point
            int m = (l + r)/2;
            
            //sort first and second halves
            transitions.addAll(sort(arr, l, m));
            transitions.addAll(sort(arr, m + 1, r));
            
            //merge sorted halves
            transitions.addAll(merge(arr, l, m, r));
        }
	
	return transitions;
    }
    
    @Override
    public ArrayList<Transition> startSort(Node[] array) {
	ArrayList<Transition> transitions = new ArrayList<>();
	this.tmp = new Node[array.length];
	
        transitions.addAll(sort(array, 0, array.length - 1));
        transitions.add(colorCNode(Arrays.asList(array), SORTED_COLOR));
	
        return transitions;
    }
    
}
