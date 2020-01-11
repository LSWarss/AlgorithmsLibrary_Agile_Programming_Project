package sorting;

import node.Node;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import node.Node;

//public class InsertionSort extends AbstractSorting {
//
//  private ArrayList<Transition> transitions;
//
//  public InsertionSort() {
//    this.transitions = new ArrayList<>();
//  }
//
//  @Override
//  public ArrayList<Transition> Sort(Node[] arr) {
//
//    for (int i = 1; i < arr.length; i++) {
//      int j = i - 1;
//      CNode key = arr[i];
//      int keyIndx = i;
//
//      transitions.add(colorCNode(arr, SELECT_COLOR, i));
//
//      while(j >= 0 && arr[j].getValue() > key.getValue()) {
//        pt.getChildren().add(arr[j].moveX(DX));
//        arr[j + 1] = arr[j];
//        j--;
//      }
//
//      arr[j + 1] = key;
//
//      pt.getChildren().add(key.moveX(DX * (j + 1 - i)));
//      transitions.add(pt);
//      transitions.add(colorCNode(arr, START_COLOR, j + 1));
//
//    }
//
//    transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));
//
//    return transitions;
//
//  }
  
//}
