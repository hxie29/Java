/* 
(Create a simple calculator) Write a program to perform addition, subtraction,
multiplication, and division, as shown in Figure 15.27a.
 */
package c15_EventsAnimations;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class E1504 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        HBox box = new HBox(20);
        box.setAlignment(Pos.CENTER);
        Button add = new Button("add");
        Button subtract = new Button("subtract");
        Button multiply = new Button("multiply");
        Button divide = new Button("divide");
        box.getChildren().addAll(add, subtract, multiply, divide);

        Label n1 = new Label("Number 1:");
        Label n2 = new Label("Number 2:");
        Label n3 = new Label("Result:");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        tf3.setEditable(false);
        
        HBox inputbox = new HBox(20);
        inputbox.getChildren().addAll(n1,tf1,n2,tf2,n3,tf3);
        inputbox.setAlignment(Pos.CENTER);


        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setCenter(inputbox);
        pane.setBottom(box);

        add.setOnAction(e -> tf3.setText(String.format("%.2f", Double.parseDouble(tf1.getText()) + Double.parseDouble(tf2.getText()))));

        subtract.setOnAction(e -> tf3.setText(String.format("%.2f", Double.parseDouble(tf1.getText()) - Double.parseDouble(tf2.getText()))));
        
        multiply.setOnAction(e -> tf3.setText(String.format("%.2f", Double.parseDouble(tf1.getText()) * Double.parseDouble(tf2.getText()))));

        divide.setOnAction(e -> tf3.setText(String.format("%.2f", Double.parseDouble(tf1.getText()) / Double.parseDouble(tf2.getText()))));

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Simple calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args ){
        launch(args);
    }  
}
