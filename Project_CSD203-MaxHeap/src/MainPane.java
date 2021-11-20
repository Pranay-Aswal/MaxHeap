import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainPane extends BorderPane {
    Font font = new Font(20);
    public MaxHeap<Integer> heap = new MaxHeap<>(Integer::compareTo);
    public List<Integer> list;
    public Pane pane;

    public MainPane() {
        list = new ArrayList<>(heap.getList());
        pane = new Pane();
        setCenter(pane);

        HBox inputPane = new HBox();                             //Top Pane- Add, Remove, Find, PreOrder Button Functions
        Label textLabel = new Label("Insert a value: ");
        textLabel.setFont(font);
        Text alertText = new Text();
        alertText.setFont(font);
        TextField elementTextField = new TextField();
        Button removeButton = new Button("Remove");
        Button addButton = new Button("Add");
        Button findButton = new Button("Find");
        Button preorderButton = new Button("Pre-Order");
        inputPane.getChildren().addAll(textLabel, elementTextField, addButton, removeButton,findButton,preorderButton);
        inputPane.setSpacing(10.0);
        inputPane.setPadding(new Insets(5, 5, 5, 450));
        setTop(inputPane);

        BorderPane bottomPane = new BorderPane();                   //BorderPane(Bottom) For Bottom part of Main BorderPane
        HBox infoPane = new HBox();
        Label labHeight = new Label("Height of tree:");
        Label labHeightVal = new Label("   ");
        Label labVertices = new Label("Number of vertices:");
        Label labVerticesVal = new Label("   ");
        labHeight.setFont(font);
        labHeightVal.setFont(font);
        labVertices.setFont(font);
        labVerticesVal.setFont(font);
        infoPane.getChildren().addAll(labHeight,labHeightVal,labVertices,labVerticesVal);
        infoPane.setPadding(new Insets(5, 5, 20, 10));
        infoPane.setSpacing(10.0);
        bottomPane.setBottom(infoPane);
        setBottom(bottomPane);

        HBox preOrderPane = new HBox();                             //BorderPane(Top) For Top part of Main BorderPane
        preOrderPane.setPadding(new Insets(5, 5, 5, 10));
        preOrderPane.setSpacing(10.0);
        preOrderPane.getChildren().addAll();
        bottomPane.setTop(preOrderPane);
        setBottom(bottomPane);

        addButton.setOnMouseClicked(e -> {                          //Event Handling for Add Button
            try {
                preOrderPane.getChildren().clear();
                inputPane.getChildren().remove(alertText);
                heap.add(Integer.parseInt(elementTextField.getText()));
                pane.getChildren().clear();
                list = heap.getList();
                labHeightVal.setText("  " + height(list.size()) + "  ");
                labVerticesVal.setText("  " + list.size() + "  ");
                labHeightVal.setUnderline(true);
                labVerticesVal.setUnderline(true);
                printTree();
            }catch (IllegalArgumentException E){
                alertText.setText("Input a valid Integer!");
                inputPane.getChildren().add(alertText);
            }

        });

        removeButton.setOnMouseClicked(e -> {                       //Event Handling for Remove Button
            try {
                preOrderPane.getChildren().clear();
                inputPane.getChildren().remove(alertText);
                heap.remove();
                list = heap.getList();
                pane.getChildren().clear();
                if(height(list.size())>-1)
                labHeightVal.setText("  " + height(list.size()) + "  ");
                else labHeightVal.setText("  " + "Please add Nodes," + "  ");
                labVerticesVal.setText("  " + list.size() + "  ");
                labHeightVal.setUnderline(true);
                labVerticesVal.setUnderline(true);
                printTree();
            }catch (IllegalArgumentException E){
                alertText.setText("Input a valid Integer!");
                inputPane.getChildren().add(alertText);
            }
        });

        findButton.setOnMouseClicked(e -> {                     //Event Handling for Find Button

            try {
                if (!list.contains(Integer.parseInt(elementTextField.getText()))) {
                    inputPane.getChildren().remove(alertText);
                    alertText.setText("Node not Found");
                    inputPane.getChildren().add(alertText);
                } else {
                    pane.getChildren().clear();
                    inputPane.getChildren().remove(alertText);
                    preOrderPane.getChildren().clear();
                    Find(Integer.parseInt(elementTextField.getText()));
                }
            } catch (IllegalArgumentException E) {
                inputPane.getChildren().remove(alertText);
                alertText.setText("Input a valid Integer!");
                inputPane.getChildren().add(alertText);
                preOrderPane.getChildren().clear();
                printTree();
            }

        });

        preorderButton.setOnMouseClicked(e ->{                  //Event Handling for Pre-Order Button
            preOrderPane.getChildren().clear();
            list = heap.getList();
            Text text;
            if(list.isEmpty()){
                text = new Text("         Heap is empty:      Please input Nodes");
            }else text = new Text("Nodes in Pre-Order:");
            text.setFont(font);
            preOrderPane.getChildren().add(text);
            list.sort(Comparator.reverseOrder());
            for (int i = 0; i < list.size() - 1; i++) {
                Text element = new Text();
                element.setFont(font);
                element.setText("" + list.get(i) + ", ");
                preOrderPane.getChildren().add(element);
            }
            Text element = new Text();
            element.setFont(font);
            element.setText("" + list.get(list.size() - 1) + "");
            preOrderPane.getChildren().add(element);

        });

    }

    private void Find(int find){            //Find method to find elements, passing TextField element as argument
        if(list.get(0)==find) {
            new printCircle(750, 50, 750, 10, list.get(0), Color.LIME, pane);
        }else {
            new printCircle(750, 50,750, 10, list.get(0), pane);
        }
        new printSubtrees(750, 50, 0, 1000, find, list, pane);
    }

    public void printTree() {
        if (list.size() == 0)
            return;
        new printCircle(750, 50,750, 10, list.get(0), pane); //Root Node
        new printSubtrees(750, 50, 0, 1000, list, pane);                //Recursive function to print SubTrees
    }

    static int height(int N)                    //Method to calculate Height of Max-Heap passing number of nodes as arguments
    {
        return (int) (Math.ceil(Math.log(N +
                1) / Math.log(2)) - 1);
    }

}



