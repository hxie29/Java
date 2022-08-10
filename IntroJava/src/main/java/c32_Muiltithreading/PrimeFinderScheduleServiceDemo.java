package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrimeFinderScheduleServiceDemo extends Application {
    Button btStart = new Button("Start");
    Button btReset = new Button("Reset");
    Button btCancel = new Button("Cancel");
    Button btExit = new Button("Exit");
    boolean started = false;

    public static void main(String[] args) {Application.launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        ScheduledService<ObservableList<Long>> service = new ScheduledService<>() {
            @Override
            protected Task<ObservableList<Long>> createTask() {
                return new PrimeFinderTask();
            }
        };
        //condigure the scheduled service
        service.setDelay(Duration.seconds(5));
        /*The minimum amount of time to allow between the start of the last run and the start of the next run.
        The actual period (also known as cumulativePeriod) will depend on this property
        as well as the backoffStrategy and number of failures.*/
        service.setPeriod(Duration.seconds(30));
        service.setMaximumFailureCount(5);

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
