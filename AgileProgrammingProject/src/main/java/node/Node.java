package node;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Node extends Rectangle {

    private int value;

    public Node(int value){this.value = value;}

    public int getValue(){return this.value;} //gets the value of node

    public TranslateTransition moveX(int x){
        TranslateTransition tTransition = new TranslateTransition();
        tTransition.setNode(this); //sets the node of translateTransitions
        tTransition.setDuration(Duration.millis(100)); //sets the duration of change
        tTransition.setByX(x); //moves the node to the x place

        return tTransition;
    }





}
