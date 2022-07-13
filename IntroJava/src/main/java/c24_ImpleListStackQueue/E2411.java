/*(Animation: queue) Write a program to animate the enqueue and dequeue
operations on a queue, as shown in Figure 24.20b.*/
package c24_ImpleListStackQueue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E2411 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        QueuePane queuePane = new QueuePane();
        queuePane.setStyle("-fx-border-color: black");
        Text text = new Text("This is animation for queue");

        TextField tfValue = new TextField();
        tfValue.setPrefColumnCount(5);
        Label lbValue = new Label("Enter a value: ", tfValue);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);

        Button btEnqueue = new Button("Enqueue");
        Button btDequeue = new Button("Dequeue");
        Button btReset = new Button("Start over");

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(lbValue, btEnqueue, btDequeue, btReset);

        pane.getChildren().addAll(text, queuePane, controlPanel);
        btEnqueue.setOnAction(e -> {
            if (isDigit(tfValue.getText()))
                queuePane.enqueue(Integer.parseInt(tfValue.getText()));
        });
        btDequeue.setOnAction(e -> tfValue.setText("" + queuePane.dequeue()));
        btReset.setOnAction(e -> queuePane.reset());

        Scene scene = new Scene(pane);
        stage.setTitle("Queue visualization");
        stage.setScene(scene);
        stage.show();
    }

    private static boolean isDigit(String s) {
        if (s.length() == 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args){Application.launch(args);}
}
