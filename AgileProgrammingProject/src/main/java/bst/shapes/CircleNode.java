package bst.shapes;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public final class CircleNode {


    // == Customization ==
    final Font font = Font.font("Abel Font", FontWeight.BOLD, 16);

    public static final int radius = 20; //Radius of the node

    private final Integer searchKey; //Search key for searching and deleting circle nodes

    private Point2D point;
    private Color backgroundColor;
    private Color borderColor;
    private Color fontColor;

    // == Constructors ==

    public CircleNode(Integer searchKey){
        this.searchKey = searchKey;
        this.backgroundColor = Color.web("#b1b1cd");
    }

    public CircleNode(Integer searchKey, Point2D point){
        this.searchKey = searchKey;
        this.point = point;
        // == Node customization ==
        this.backgroundColor = Color.rgb(177, 177, 205);
        this.borderColor = Color.rgb(0, 0, 0);
        this.fontColor = Color.rgb(0, 0, 0);
    }

    // == Public Methods

    public void generate(GraphicsContext graphicsContext){
        //Setting the line width
        graphicsContext.setLineWidth(3);

        //Creating a circle node
        graphicsContext.setFill(backgroundColor);
        graphicsContext.fillOval(point.getX() - radius, point.getY() - radius, 2 * radius, 2 * radius);

        //Creating border color
        graphicsContext.setStroke(borderColor);
        graphicsContext.strokeOval(point.getX() - radius, point.getY() - radius, 2 * radius, 2 * radius);

        //Draw the id number inside the circle
        graphicsContext.setFont(font);
        graphicsContext.setFill(getFontColor());
        graphicsContext.fillText(getKey(), point.getX() - 10,
                point.getY() + 10);
    }

    public void setHighlighter(boolean highlight) {
        if (highlight) {
            setFontColor(Color.rgb(0, 0, 0));
            setBackgroundColor(Color.rgb(102, 166, 244));
            setBorderColor(Color.rgb(0, 0, 0));

        } else {
            setFontColor(Color.rgb(0,0,0));
            setBackgroundColor(Color.rgb(177, 177, 205));
            setBorderColor(Color.rgb(0,0,0));
        }
    }

    // == Getters and Setters ==

    private String getKey() {
        return Integer.toString(getSearchKey());
    }

    public Integer getSearchKey() {
        return this.searchKey;
    }


    public Color getBorderColor() {
        return borderColor;
    }


    private void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    private void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }


    public int getRadius() {
        return radius;
    }

    public Color getFontColor() {
        return this.fontColor;
    }

    private void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }




}
