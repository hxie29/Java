/*You can use a thread to control an animation and run the code in JavaFX GUI thread
using the Platform.runLater method.*/
package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class E32L02 extends Application {
    private String text = " ";

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        Label lbText = new Label("Programming is fun");
        pane.getChildren().add(lbText);

        new Thread(() -> {
            try {
                while (true) {
                    if (lbText.getText().trim().length() == 0)
                        text = "Welcome";
                    else
                        text = " ";

                    Platform.runLater(() -> lbText.setText(text));
                    Thread.sleep(200);
                }
            } catch (InterruptedException ignored) {
            }
        }).start();

        Scene scene = new Scene(pane, 200, 50);
        stage.setTitle("Flash text");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
