package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class E15L19 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        MapPane map = new MapPane();
        map.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) map.enlarge();
            else if (e.getCode() == KeyCode.DOWN) map.shrink();
        });
        
        Scene scene = new Scene(map, 500,500);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();

        map.requestFocus();
    }

    public static void main(String[] args ){
        launch(args);
    }  
}
