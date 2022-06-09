/* 
(Traffic lights) Write a program that simulates a traffic light. The program lets
the user select one of three lights: red, yellow, or green. When a radio button
is selected, the light is turned on. Only one light can be on at a time (see
Figure 16.37a). No light is on when the program starts.
 */
package c16_UIMultimedia;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

public class E1603 extends Application {
    protected Pane figurePane = new Pane();
    protected Color fill = Color.TRANSPARENT;

    protected RadioButton rb1 = new RadioButton("Red");
    protected RadioButton rb2 = new RadioButton("Yellow");
    protected RadioButton rb3 = new RadioButton("Green");
    protected Rectangle r = new Rectangle(50,50,300,100);
    protected ArrayList<Circle> lights = new ArrayList<>();
    protected Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN};
    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < 3; i++) {
            lights.add(new Circle(120 + i * 80, 100,30));
            lights.get(i).setStroke(Color.BLACK);
            lights.get(i).setFill(Color.TRANSPARENT);
        }

        r.setStroke(Color.BLACK);
        r.setFill(Color.TRANSPARENT);
        figurePane.getChildren().addAll(r);
        figurePane.getChildren().addAll(lights);

        BorderPane pane = new BorderPane();

        HBox paneRbs = new HBox(20);
        paneRbs.setAlignment(Pos.CENTER);
        paneRbs.setPadding(new Insets(5,5,5,5));
        paneRbs.setStyle("-fx-border-color: green");
        
        paneRbs.getChildren().addAll(rb1, rb2,rb3);
                
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        
        pane.setBottom(paneRbs);
        pane.setCenter(figurePane);
        
        rb1.setOnAction(e -> paint(0));
        
        rb2.setOnAction(e -> paint(1));

        rb3.setOnAction(e -> paint(2));
        

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Stackpane with shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void paint(int index) {
        figurePane.getChildren().removeAll(lights);
        for (int i = 0; i < lights.size(); i++) {
            if (i == index) lights.get(i).setFill(colors[i]);
            else lights.get(i).setFill(Color.TRANSPARENT);
        }
        figurePane.getChildren().addAll(lights);
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}

class ShapePane extends BorderPane {
    
}