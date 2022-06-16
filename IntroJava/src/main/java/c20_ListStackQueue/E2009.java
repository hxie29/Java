/*(Remove the largest ball first) Modify Listing 20.10, MultipleBallApp
.java to assign a random radius between 2 and 20 when a ball is created.
When the - button is clicked, one of largest balls is removed.*/
package c20_ListStackQueue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2009 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        MultipleBallBigPane ballPane = new MultipleBallBigPane();
        pane.setCenter(ballPane);

        Button btAdd = new Button("+");
        Button btRemove = new Button("-");
        HBox controlPanel = new HBox(10);
        controlPanel.getChildren().addAll(btAdd, btRemove);
        controlPanel.setAlignment(Pos.CENTER);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(5);
        pane.setTop(sbSpeed);

        btAdd.setOnAction(e -> ballPane.add());
        btRemove.setOnAction(e -> ballPane.remove());
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Multiple bouncing balls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
