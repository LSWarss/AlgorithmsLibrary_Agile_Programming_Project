package bst.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ConnectionLine {

    // == Customization ==
    private static final Color HighlightingColor = Color.rgb(102, 166, 244);
    private static final Color UI_Color = Color.rgb(244,244,244);


    // Circles attributes
    private Point2D point, point2;
    private Color color;

    // == Constructors ==

    public ConnectionLine() {
        this.color = UI_Color;
    }

    public ConnectionLine(Point2D point, Point2D point2){
        this.point = point;
        this.point2 = point2;
        this.color = UI_Color;
    }

    // == Public Methods ==

    public void generate(GraphicsContext graphicsContext){
        graphicsContext.setLineWidth(4);

        graphicsContext.setStroke(color);
        graphicsContext.strokeLine(point.getX(), point.getY(),point2.getX(),point2.getY());
    }

    // == Getters and Setters

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point, Point2D point2) {
        this.point = point;
        this.point2 = point2;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public void setHighlighter(boolean highlight) {
        if (highlight) {
            this.color = HighlightingColor;
        } else {
            this.color = UI_Color;
        }
    }


}
