package chap15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E15L09 extends Application {
    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage primaryStage) {
        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);
        Button enlarge = new Button("Enlarge");
        Button shrink = new Button("Shrink");
        box.getChildren().addAll(enlarge, shrink);

        enlarge.setOnAction(e -> circlePane.enlarge());
        shrink.setOnAction(e -> circlePane.shrink());
        
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setCenter(circlePane);
        pane.setBottom(box);
        BorderPane.setAlignment(box, Pos.CENTER);
        
        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) 
                circlePane.enlarge();
            else if (e.getButton() == MouseButton.SECONDARY) 
                circlePane.enlarge();
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Control circle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //This doesnt work?
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) circlePane.enlarge();
            else if (e.getCode() == KeyCode.DOWN) circlePane.shrink();
        });
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
