package sorting;


import javafx.animation.Transition;
import javafx.scene.paint.Color;
import node.Node;
import java.util.ArrayList;
import java.util.Arrays;

public class quickSort extends AbstractSorting {

    private static final Color PIVOT_COLOR = Color.DARKMAGENTA;
    private ArrayList<Transition> transitions;


    public void sort(Node[] array, int low, int high){
        if(low < high) {
            int p = partition(array, low, high); //this is partitioning index
            //Recursively sort elements before and after partition
            sort(array, low, p -1);
            sort(array, p+1, high);
        }
    } //Description: Main function for implementing quickSort()

    private  int partition(Node[] array, int low, int high){
        int i = low;
        transitions.add(colorCNode(array,PIVOT_COLOR,high));

        for (int j = low; j < high; j++) {
            transitions.add(colorCNode(array, SELECT_COLOR, j));
            if (array[j].getValue() < array[high].getValue()) {
                transitions.add(swap(array, i, j));
                transitions.add(colorCNode(array, START_COLOR, i));
                i++;
            } else {
                transitions.add(colorCNode(array, START_COLOR, j));
            }
        }
        transitions.add(swap(array, i, high));
        transitions.add(colorCNode(array, START_COLOR, i));

        return i;

    } //Description: Function takes the last element as pivot, then it places it in sorted array, and then places all smaller then the pivot on the left of the pivot and greater elements on right from the pivot.


    @Override
    public ArrayList<Transition> startSort(Node[] array) {
        sort(array, 0, array.length-1);
        transitions.add(colorCNode(Arrays.asList(array), SORTED_COLOR));
        return transitions;
    }
}
