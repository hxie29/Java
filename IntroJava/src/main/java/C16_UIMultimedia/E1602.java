/* 
(Select geometric figures) Write a program that draws various figures, as shown
in Figure 16.36b. The user selects a figure from a radio button and uses a check
box to specify whether it is filled.
 */
package chap16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class E1602 extends Application {
    protected StackPane figurePane = new StackPane();
    protected Color fill = Color.TRANSPARENT;

    protected RadioButton rb1 = new RadioButton("Circle");
    protected RadioButton rb2 = new RadioButton("Square");
    protected RadioButton rb3 = new RadioButton("Ellipse");
    protected CheckBox chkFill = new CheckBox("Fill");


    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        HBox paneRbs = new HBox(20);
        paneRbs.setAlignment(Pos.CENTER);
        paneRbs.setPadding(new Insets(5,5,5,5));
        paneRbs.setStyle("-fx-border-color: green");
        
        paneRbs.getChildren().addAll(rb1, rb2,rb3, chkFill);
                
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        
        pane.setBottom(paneRbs);
        pane.setCenter(figurePane);
        
        paint();
        chkFill.setOnAction(e -> { 
            if (chkFill.isSelected()) fill = Color.RED;
            else fill = Color.TRANSPARENT;
            paint();
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Stackpane with shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void paint() {
        rb1.setOnAction(e -> {
            figurePane.getChildren().clear();
            Circle c = new Circle(50);
            figurePane.getChildren().add(c);
            c.setStroke(Color.BLACK);
            c.setFill(fill);
        });
        
        rb3.setOnAction(e -> {
            figurePane.getChildren().clear();
            Ellipse c = new Ellipse(100,50);
            figurePane.getChildren().add(c);
            c.setStroke(Color.BLACK);
            c.setFill(fill);
        });
        
        rb2.setOnAction(e -> {
            figurePane.getChildren().clear();
            Rectangle c = new Rectangle(100,50);
            figurePane.getChildren().add(c);
            c.setStroke(Color.BLACK);
            c.setFill(fill);
        });
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
