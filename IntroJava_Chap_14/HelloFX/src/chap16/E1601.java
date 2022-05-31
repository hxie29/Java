/* 
(Use radio buttons) Write a GUI program as shown in Figure 16.36a. You can
use buttons to move the message to the left and right and use the radio buttons to
change the color for the message displayed.
 */
package chap16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class E1601 extends Application {
    protected Text text = new Text(50,50, "This is a text.");

    protected BorderPane getPane() {
        HBox paneButtons = new HBox(20);
        paneButtons.setAlignment(Pos.CENTER);
        paneButtons.setStyle("-fx-border-color: green");
        
        Button btLeft = new Button("<=");
        btLeft.setContentDisplay(ContentDisplay.LEFT);
        Button btRight = new Button("=>");
        btRight.setContentDisplay(ContentDisplay.RIGHT);
        paneButtons.getChildren().addAll(btLeft, btRight);
    
        
        btLeft.setOnAction(e -> text.setX(text.getX() -10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));
        
        HBox paneRbs = new HBox(20);
        paneRbs.setAlignment(Pos.CENTER);
        paneRbs.setPadding(new Insets(5,5,5,5));
        paneRbs.setStyle("-fx-border-color: green");
        
        RadioButton rb1 = new RadioButton("Red");
        RadioButton rb2 = new RadioButton("Green");
        RadioButton rb3 = new RadioButton("Blue");
        RadioButton rb4 = new RadioButton("Yellow");
        paneRbs.getChildren().addAll(rb1, rb2,rb3, rb4);
                
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);
        
        BorderPane pane = new BorderPane();
        pane.setBottom(paneButtons);
        pane.setCenter(new Pane(text));
        pane.setTop(paneRbs);

        rb1.setOnAction(e -> {
            if (rb1.isSelected()) text.setFill(Color.RED);
        });

        rb2.setOnAction(e -> {
            if (rb2.isSelected()) text.setFill(Color.GREEN);
        });

        rb3.setOnAction(e -> {
            if (rb3.isSelected()) text.setFill(Color.BLUE);
        });

        rb4.setOnAction(e -> {
            if (rb4.isSelected()) text.setFill(Color.YELLOW);
        });

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("Button demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}