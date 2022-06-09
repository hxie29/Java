package c16_UIMultimedia;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class E16L04 extends E16L03 {

    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        VBox paneRbs = new VBox(20);
        paneRbs.setPadding(new Insets(5,5,5,5));
        paneRbs.setStyle("-fx-border-color: green");

        RadioButton rb1 = new RadioButton("Red");
        RadioButton rb2 = new RadioButton("Green");
        RadioButton rb3 = new RadioButton("Blue");
        paneRbs.getChildren().addAll(rb1, rb2,rb3);
        
        pane.setLeft(paneRbs);

        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        rb1.setOnAction(e -> {
            if (rb1.isSelected()) text.setFill(Color.RED);
        });

        rb2.setOnAction(e -> {
            if (rb2.isSelected()) text.setFill(Color.GREEN);
        });

        rb3.setOnAction(e -> {
            if (rb3.isSelected()) text.setFill(Color.BLUE);
        });
       
        return pane;
    }
    //Start method is inherited

    public static void main(String[] args ){
        launch(args);
    }
    
}