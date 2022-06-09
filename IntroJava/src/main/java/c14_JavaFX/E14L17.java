package c14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E14L17 extends Application {
    @Override
    public void start(Stage primaryStage) {

        // Using border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(new MyEllipse(), 250, 150);
        primaryStage.setTitle("Show Ellipse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
