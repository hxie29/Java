package c16_UIMultimedia;

import c15_EventsAnimations.BallPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;

public class E16L12 extends Application {
    private final BallPane ballPane = new BallPane();

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        
        ScrollBar sb = new ScrollBar();
        sb.setMax(20);
        sb.setUnitIncrement(2);
        sb.setBlockIncrement(2);
        pane.setBottom(sb);
        
        ballPane.getRateProperty().bind(sb.valueProperty());
        ballPane.play();

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Slider demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}