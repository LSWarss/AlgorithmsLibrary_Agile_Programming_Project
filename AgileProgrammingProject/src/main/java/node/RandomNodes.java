package node;

import javafx.scene.paint.Color;
import view.AnimationController;

import java.util.Random;

public class RandomNodes {

    public RandomNodes(){

    }

    public static Node[] randomNodes(int n){
        Node[] array = new Node[n];
        Random rand = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = new Node(1 + rand.nextInt(array.length)); //Inserting new node to the list with value from 1 to random value in range from 0 to array.lenght
            array[i].setX(i * (AnimationController.WINDOW_WIDTH / array.length));
            array[i].setFill(Color.BLUE);
            setNodeDim(array[i], array.length);
        }

        return array;
    }

    private static void setNodeDim(Node node, int n) {
        node.setWidth(AnimationController.WINDOW_WIDTH / n -
                AnimationController.GAP);
        node.setHeight(((AnimationController.WINDOM_HEIGHT - AnimationController.BUTTONS_BOUNDRY) / n) * node.getValue());
    }
}
