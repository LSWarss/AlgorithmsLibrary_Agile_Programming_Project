package view;

import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import node.Node;
import node.RandomNodes;
import sorting.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimationController extends BorderPane {

    // == Configuration of spacing and look of the animation window
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;
    public static final int GAP = 10;
    public static final int BUTTONS_BOUND = 100;

    public static int NR_NODES = 40; //number of nodes displayed

    private static AbstractSorting abstractSort;

    // == Grid and alignment of elements ==
    private Pane window;
    private HBox buttons;
    // == Buttons==
    private Button sortingButton;
    private Button randomButton;
    private ChoiceBox<AbstractSorting> abstractSortingChoiceBox;
    private Button bstButton;
    private Button stopButton;

    private Node[] nodes;

    public AnimationController(){
        this.window = new Pane();
        this.buttons = new HBox();

        this.setCenter(window);
        this.setBottom(buttons);

        this.sortingButton = new Button("Sort");
        this.randomButton = new Button ("Randomise");
        this.abstractSortingChoiceBox = new ChoiceBox<>();
        this.bstButton = new Button("BST");
        this.stopButton = new Button("Stop");

        this.nodes = RandomNodes.randomNodes(NR_NODES);

        buttons.getChildren().add(sortingButton);
        buttons.getChildren().add(randomButton);
        buttons.getChildren().add(abstractSortingChoiceBox);

        buttons.setAlignment(Pos.CENTER);

        for(javafx.scene.Node but : buttons.getChildren()){
            buttons.setMargin(but, new Insets(20,5,20,5));
        }


        List<AbstractSorting> abstractSortList = new ArrayList<>();
//        abstractSortList.add(new BubbleSort());
        abstractSortList.add(new InsertionSort());
        abstractSortList.add(new MergeSort());
        abstractSortList.add(new quickSort());
        abstractSortList.add(new HeapSort());

        window.getChildren().addAll(Arrays.asList(nodes));

        sortingButton.setOnAction(event -> {
            sortingButton.setDisable(true);
            randomButton.setDisable(true);

            abstractSort = abstractSortingChoiceBox.getSelectionModel().getSelectedItem();

            SequentialTransition sq = new SequentialTransition();

            sq.getChildren().addAll(abstractSort.startSort(nodes));

            sq.setOnFinished(e -> {
                randomButton.setDisable(false);
            });

            sq.play();

        });

        randomButton.setOnAction(event -> {
            sortingButton.setDisable(false);
            window.getChildren().clear();

            nodes = RandomNodes.randomNodes(NR_NODES);

            window.getChildren().addAll(Arrays.asList(nodes));
        });

        abstractSortingChoiceBox.setItems(FXCollections.observableArrayList(
                abstractSortList
        ));

        stopButton.setOnAction(event -> {
            window.getChildren().clear();
            sortingButton.setDisable(false);
            randomButton.setDisable(false);
        });  // Stop button implementation for interface

        bstButton.setOnAction(event -> {

        });

        abstractSortingChoiceBox.getSelectionModel().select(5);

        abstractSortingChoiceBox.setConverter(new StringConverter<AbstractSorting>() {
            @Override
            public String toString(AbstractSorting abstractSort) {
                if(abstractSort == null) {
                    return "";
                } else {
                    return abstractSort.getClass().getSimpleName();
                }
            }

            @Override
            public AbstractSorting fromString(String s) {
                return null;
            }
        });

    }


}
