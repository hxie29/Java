package chap15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class E15L18 extends Application {
    BallPane ball = new BallPane();

    @Override
    public void start(Stage primaryStage) { 
        ball.setPadding(new Insets(50));
        ball.setOnMousePressed(e -> ball.pause());
        ball.setOnMouseReleased(e -> ball.play());  

        ball.setOnKeyPressed( e -> {
            if (e.getCode() == KeyCode.UP) ball.increaseSpeed();
            else if (e.getCode() == KeyCode.DOWN) ball.decreaseSpeed();
        });
        
        Scene scene = new Scene(ball, 500,500);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();

        ball.requestFocus();
    }

    public static void main(String[] args ){
        launch(args);
    }  
}
