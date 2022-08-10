// (Revise Listing 32.1) Rewrite Listing 32.1 to display the output in a text area.
package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class E3201 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int times = 100;
        TextArea ta = new TextArea();
        ScrollPane pane = new ScrollPane(ta);
        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                Platform.runLater(() -> ta.appendText("a"));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                Platform.runLater(() -> ta.appendText("b"));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                Platform.runLater(() -> ta.appendText("c"));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                int num = i+1;
                Platform.runLater(() -> ta.appendText(num +""));
            }
        }).start();

        Scene scene = new Scene(pane, 200,100);
        stage.setTitle("Display print in text area");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

