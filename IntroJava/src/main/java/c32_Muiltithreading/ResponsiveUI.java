package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResponsiveUI extends Application {
    Label lbStatus = new Label("Not started...");
    Button btStart = new Button("Start");
    Button btExit = new Button("Exit");

    public static void main(String[] args) {Application.launch(args);}
    @Override
    public void start(Stage stage) throws Exception {
        btStart.setOnAction(e -> startTask());
        btExit.setOnAction(e -> stage.close());

        HBox hb = new HBox(5, btStart, btExit);
        VBox vBox = new VBox(10,lbStatus, hb);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("A responsive UI with RunLater");
        stage.show();
    }

    private void startTask() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String status = "Processing " + i + " of 10";
                // the UI component methods can not be called outside JavaFX Application thread
                // Platform.runLater() put the call back to JavaFX Application thread stack
                //This is not ideal, because the long running task is coupled tighly with UI component
                // and the UI component (front end) is referenced in the backend
                Platform.runLater(() -> lbStatus.setText(status));
                System.out.println(status);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
