import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.List;

public class printSubtrees {
    private static final int yDISTANCE = 200;


    public printSubtrees(int rootXPosition, int rootYPosition, int rootListIndex, int length, List list,Pane pane) {  //Constructor for normal printing of trees
        int leftNodeIndex = rootListIndex * 2 + 1;
        int rightNodeIndex = rootListIndex * 2 + 2;
        int xLeftNodePosition;
        int yLeftNodePosition;
        int xRightNodePosition;
        int yRightNodePosition;
        if (leftNodeIndex < list.size()) {
            xLeftNodePosition = rootXPosition - (length / 3);
            yLeftNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xLeftNodePosition, yLeftNodePosition, rootXPosition, rootYPosition, (Integer) list.get(leftNodeIndex), pane);
        } else
            return;
        if (rightNodeIndex < list.size()) {
            xRightNodePosition = rootXPosition + (length / 3);
            yRightNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xRightNodePosition, yRightNodePosition, rootXPosition, rootYPosition, (Integer) list.get(rightNodeIndex), pane);
        } else
            return;

        new printSubtrees(xLeftNodePosition, yLeftNodePosition, leftNodeIndex, length / 2, list, pane);
        new printSubtrees(xRightNodePosition, yRightNodePosition, rightNodeIndex, length / 2, list, pane);
    }

    public printSubtrees(int rootXPosition, int rootYPosition, int rootListIndex, int length, int find, List list,Pane pane) {  //Constructor for searching(Find button element) and printing Tree
        int leftNodeIndex = rootListIndex * 2 + 1;
        int rightNodeIndex = rootListIndex * 2 + 2;
        int xLeftNodePosition;
        int yLeftNodePosition;
        int xRightNodePosition;
        int yRightNodePosition;

        if (leftNodeIndex < list.size()) {
            xLeftNodePosition = rootXPosition - (length / 3);
            yLeftNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xLeftNodePosition, yLeftNodePosition, rootXPosition, rootYPosition, (Integer) list.get(leftNodeIndex), pane);
        } else
            return;
        if ((Integer) list.get(leftNodeIndex) == find) {
            xLeftNodePosition = rootXPosition - (length / 3);
            yLeftNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xLeftNodePosition, yLeftNodePosition, rootXPosition, rootYPosition, (Integer) list.get(leftNodeIndex), Color.LIME, pane);
        } else {
            xLeftNodePosition = rootXPosition - (length / 3);
            yLeftNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xLeftNodePosition, yLeftNodePosition, rootXPosition, rootYPosition, (Integer) list.get(leftNodeIndex), pane);
        }
        if (rightNodeIndex < list.size()) {
            xRightNodePosition = rootXPosition + (length / 3);
            yRightNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xRightNodePosition, yRightNodePosition, rootXPosition, rootYPosition, (Integer) list.get(rightNodeIndex), pane);
        } else
            return;
        if ((Integer) list.get(rightNodeIndex) == find) {
            {
                xRightNodePosition = rootXPosition + (length / 3);
                yRightNodePosition = rootYPosition + yDISTANCE / 2;
                new printCircle(xRightNodePosition, yRightNodePosition, rootXPosition, rootYPosition, (Integer) list.get(rightNodeIndex), Color.LIME, pane);
            }
        } else {
            xRightNodePosition = rootXPosition + (length / 3);
            yRightNodePosition = rootYPosition + yDISTANCE / 2;
            new printCircle(xRightNodePosition, yRightNodePosition, rootXPosition, rootYPosition, (Integer) list.get(rightNodeIndex), pane);
        }

        new printSubtrees(xRightNodePosition, yRightNodePosition, rightNodeIndex, length / 2, find, list, pane);
        new printSubtrees(xLeftNodePosition, yLeftNodePosition, leftNodeIndex, length / 2, find, list, pane);
    }
}

