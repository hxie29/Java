/* 
(Demonstrate TextField properties) Write a program that sets the horizontalalignment
and column-size properties of a text field dynamically, as shown in
Figure 16.38a.
 */
package chap16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;

public class E1606 extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        HBox paneRbs = new HBox(20);
        paneRbs.setAlignment(Pos.CENTER);
        paneRbs.setPadding(new Insets(5,5,5,5));
        paneRbs.setStyle("-fx-border-color: green");

        RadioButton rb1 = new RadioButton("Left");
        RadioButton rb2 = new RadioButton("Center");
        RadioButton rb3 = new RadioButton("Right");
        TextField column = new TextField();
        column.setPrefColumnCount(6);
        paneRbs.getChildren().addAll(rb1, rb2,rb3, new Label("Column Size"), column);
                
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        HBox txPane = new HBox(10);
        txPane.setAlignment(Pos.CENTER);
        TextField tf1 = new TextField("This is a text.");
        txPane.getChildren().addAll(new Label("Text Field"), tf1);
        
        pane.setBottom(paneRbs);
        pane.setCenter(txPane);
        
        rb1.setOnAction(e -> {
            tf1.setAlignment(Pos.CENTER_LEFT);
        });
        
        rb2.setOnAction(e -> {
           tf1.setAlignment(Pos.CENTER);
        });

        rb3.setOnAction(e -> {
            tf1.setAlignment(Pos.CENTER_RIGHT);
        });

        column.setOnAction(e -> tf1.setPrefColumnCount(Integer.parseInt(column.getText())));
        

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Stackpane with shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    public static void main(String[] args ){
        launch(args);
    }
    
}
