package sorting;

import javafx.animation.Transition;
import javafx.util.Duration;
import node.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort extends AbstractSorting {

    private boolean swapped;
    private ArrayList<Transition> transitions;
    public BubbleSort() {
        this.transitions = new ArrayList<>();
    }

    private ArrayList<Transition> compare(Node[] arr, int a, int b) {
        ArrayList<Transition> transitions = new ArrayList<>();

        transitions.add(colorFNode(arr, SELECT_COLOR, a, b));

        if (arr[a].getValue() > arr[b].getValue()) {
            transitions.add(swap(arr, a, b));
            swapped = true;
        }

        transitions.add(colorFNode(arr, START_COLOR, a, b));

        return transitions;
    }

    private void bubbleSort(Node[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                this.transitions.addAll(compare(arr, j, j + 1));
            }
            if (!swapped) {
                break;
            }
        }

    }

    @Override
    public ArrayList<Transition> startSort(Node[] arr) {
        bubbleSort(arr);
        this.transitions.add(colorFNode(Arrays.asList(arr), SORTED_COLOR));

        return this.transitions;

    }
}
