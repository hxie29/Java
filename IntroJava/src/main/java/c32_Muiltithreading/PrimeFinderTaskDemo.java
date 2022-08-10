package c32_Muiltithreading;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimeFinderTaskDemo extends Application {
    Button btStart = new Button("Start");
    Button btCancel = new Button("Cancel");
    Button btExit = new Button("Exit");

    public static void main(String[] args) {Application.launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        PrimeFinderTask task = new PrimeFinderTask();
        WorkerStateUI workerStateUI = new WorkerStateUI(task);

        HBox hBox = new HBox(5, btStart, btCancel, btExit);
        BorderPane pane = new BorderPane();
        pane.setCenter(workerStateUI);
        pane.setBottom(hBox);
        pane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Prime Finder Task Demo");
        stage.show();

        btStart.setOnAction(e -> {
            Thread backgroundThread = new Thread(task);
            backgroundThread.setDaemon(true);
            backgroundThread.start();
        });
        btCancel.setOnAction(e -> task.cancel());
        btExit.setOnAction(e -> stage.close());
    }
}
