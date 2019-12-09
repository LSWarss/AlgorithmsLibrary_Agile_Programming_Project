package node;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Node extends Rectangle {

    private int value;

    public Node(int value){this.value = value;}

    public int getValue(){return this.value;}

    public TranslateTransition moveX(int x){
        TranslateTransition tTransition = new TranslateTransition();
        tTransition.setNode(this);
        tTransition.setDuration(Duration.millis(100));
        tTransition.setByX(x);

        return tTransition;
    }





}
