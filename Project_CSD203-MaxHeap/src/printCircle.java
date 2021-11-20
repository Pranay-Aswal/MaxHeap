import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class printCircle {


    printCircle(int xCentrePosition, int yCentrePosition, int xParentPosition, int yParentPosition, int content, Color color,Pane pane) {       //Constructor if Find button element is found
        Circle circle = new Circle(xCentrePosition, yCentrePosition, 20);
        circle.setStroke(Color.PALEVIOLETRED);
        circle.setFill(color);
        Text text = new Text(xCentrePosition-5, yCentrePosition+5, "" + content);
        text.setFill(Color.BLACK);
        Line line = new Line(xCentrePosition, yCentrePosition - 20, xParentPosition, yParentPosition + 20);
        line.setStroke(Color.ORANGE);
        line.strokeWidthProperty().set(2.5);
        pane.getChildren().addAll(circle, text, line);

    }

    public printCircle(int xCentrePosition, int yCentrePosition, int xParentPosition, int yParentPosition, int content, Pane pane) {        //Constructor for normal circle
        Circle circle = new Circle(xCentrePosition, yCentrePosition, 20);
        circle.setStroke(Color.PALEVIOLETRED);
        circle.setFill(Color.ROYALBLUE);
        Text text = new Text(xCentrePosition-5, yCentrePosition+5, "" + content);
        text.setFill(Color.FLORALWHITE);
        Line line = new Line(xCentrePosition, yCentrePosition - 20, xParentPosition, yParentPosition + 20);
        line.setStroke(Color.ORANGE);
        line.strokeWidthProperty().set(2.5);
        pane.getChildren().addAll(circle, text, line);

    }

}
