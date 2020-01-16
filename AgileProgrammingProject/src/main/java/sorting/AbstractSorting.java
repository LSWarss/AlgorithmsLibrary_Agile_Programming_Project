package sorting;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import node.Node;
import contollers.AnimationController;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSorting {

    final Color START_COLOR = Color.SILVER;
    final Color SELECT_COLOR = Color.PURPLE;
    final Color SORTED_COLOR = Color.ROYALBLUE;

    static int DX;
    static {
        DX = AnimationController.WINDOW_WIDTH / AnimationController.NR_NODES;
    }

    ParallelTransition colorCNode(Node[] nodes, Color color, int...a) {
        ParallelTransition pt = new ParallelTransition();

        for (int i = 0; i < a.length; i++) {
            FillTransition ft = new FillTransition();
            ft.setShape(nodes[a[i]]);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(100));
            pt.getChildren().add(ft);
        }
        return pt;
    }

    ParallelTransition colorCNode(List<Node> nodeList, Color color) {
        ParallelTransition pt = new ParallelTransition();

        for (Node c : nodeList) {
            FillTransition ft = new FillTransition();
            ft.setShape(c);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(100));
            pt.getChildren().add(ft);
        }

        return pt;
    }
    ParallelTransition colorFNode(Node[] nodes, Color color, int...a) { //Faster swaps for longer animations
        ParallelTransition pt = new ParallelTransition();

        for (int i = 0; i < a.length; i++) {
            FillTransition ft = new FillTransition();
            ft.setShape(nodes[a[i]]);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(10));
            pt.getChildren().add(ft);
        }
        return pt;
    }

    ParallelTransition colorFNode(List<Node> nodeList, Color color) { //Faster swaps for longer animations
        ParallelTransition pt = new ParallelTransition();

        for (Node c : nodeList) {
            FillTransition ft = new FillTransition();
            ft.setShape(c);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(10));
            pt.getChildren().add(ft);
        }

        return pt;
    }
    ParallelTransition swap(Node[] nodes, int i, int j) {
        ParallelTransition pt = new ParallelTransition();

        int dxFactor = j - i;

        pt.getChildren().addAll(nodes[i].moveX(DX * dxFactor), nodes[j].moveX(-DX * dxFactor));

        Node tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;

        return pt;
    }

    public abstract ArrayList<Transition> startSort(Node[] array);
}
