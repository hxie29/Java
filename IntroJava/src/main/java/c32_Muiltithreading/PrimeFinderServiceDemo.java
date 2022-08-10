package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimeFinderServiceDemo extends Application {
    Button btStart = new Button("Start");
    Button btReset = new Button("Reset");
    Button btCancel = new Button("Cancel");
    Button btExit = new Button("Exit");
    boolean started = false;

    public static void main(String[] args) {Application.launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        Service<ObservableList<Long>> service = new Service<>() {
            @Override
            protected Task<ObservableList<Long>> createTask() {
                return new PrimeFinderTask();
            }
        };

        WorkerStateUI workerStateUI = new WorkerStateUI(service);

        HBox hBox = new HBox(5, btStart, btCancel,btReset, btExit);
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
        stage.setTitle("Prime Finder Service Demo");
        stage.show();

        //bind button state
        //disable cancel button when service is not running
        btCancel.disableProperty().bind(service.stateProperty().isNotEqualTo(Worker.State.RUNNING));
        // disable reset button if service is running or scheduled
        btReset.disableProperty().bind(Bindings.or(service.stateProperty().isEqualTo(Worker.State.RUNNING),
                service.stateProperty().isEqualTo(Worker.State.SCHEDULED)));

        // set event handlers
        btStart.setOnAction(e -> {
            if (started)
                service.restart();
            else {
                service.start();
                started = true;
                btStart.setText("Restart");
            }
        });
        btCancel.setOnAction(e -> service.cancel());
        btReset.setOnAction(e -> service.restart());
        btExit.setOnAction(e -> Platform.exit());
    }
}
