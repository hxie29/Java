package chap16;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;

public class E16L10 extends Application {
    protected Text text = new Text(50,50, "This is a text.");

    @Override
    public void start(Stage primaryStage) {

         //Orientation defalt is horizontal
         ScrollBar sbHorizontal = new ScrollBar();
         ScrollBar sbVertical = new ScrollBar();
         sbVertical.setOrientation(Orientation.VERTICAL);
 
         Pane textPane = new Pane();
         textPane.setMinSize(800, 800);
         textPane.getChildren().addAll(text);
 
         BorderPane pane = new BorderPane();
         pane.setCenter(textPane);
         pane.setBottom(sbHorizontal);
         pane.setRight(sbVertical);
 
         sbHorizontal.valueProperty().addListener(ov -> 
             text.setX(sbHorizontal.getValue() * textPane.getWidth() / sbHorizontal.getMax()));
         sbVertical.valueProperty().addListener(ov -> 
             text.setY(sbVertical.getValue() * textPane.getHeight() / sbVertical.getMax()));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Scroll bar demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}