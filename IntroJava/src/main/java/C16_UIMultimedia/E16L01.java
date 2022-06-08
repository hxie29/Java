package chap16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class E16L01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        ImageView flag = new ImageView(new Image("http://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/rainbow-flag.png"));
        Label lb1 = new Label("Pride flag", flag);
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        lb1.setStyle("-fx-border-color: green, -fx-border-width: 2");
        lb1.setTextFill(Color.RED);

        // Circle center location does not matter here
        Label lb2 = new Label("Circle", new Circle(25));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);

        Ellipse ellipse = new Ellipse(50,50,50,25);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(ellipse, new Label("Stack nodes"));
        Label lb3 = new Label("A pane inside a label", stack);
        lb3.setContentDisplay(ContentDisplay.RIGHT);

        HBox pane = new HBox(20);
        pane.getChildren().addAll(lb1, lb2, lb3);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Label with graphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}