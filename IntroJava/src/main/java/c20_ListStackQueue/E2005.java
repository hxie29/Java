/*(Combine colliding bouncing balls) The example in Section 20.8 displays
multiple bouncing balls. Extend the example to detect collisions. Once two
balls collide, remove the later ball that was added to the pane and add its
radius to the other ball, as shown in Figure 20.17b. Use the Suspend button
to suspend the animation, and the Resume button to resume the animation.
Add a mouse-pressed handler that removes a ball when the mouse is
pressed on the ball.*/
package c20_ListStackQueue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2005 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        MultipleBallColPane ballPane = new MultipleBallColPane();
        pane.setCenter(ballPane);

        Button btAdd = new Button("+");
        Button btRemove = new Button("-");
        Button btSuspend = new Button("Suspend");
        Button btResume = new Button("Resume");
        HBox controlPanel = new HBox(10);
        controlPanel.getChildren().addAll(btAdd, btRemove, btSuspend, btResume);
        controlPanel.setAlignment(Pos.CENTER);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(5);
        pane.setTop(sbSpeed);

        btAdd.setOnAction(e -> ballPane.add());
        btRemove.setOnAction(e -> ballPane.remove());
        btSuspend.setOnAction(e -> ballPane.pause());
        btResume.setOnAction(e -> ballPane.play());
        ballPane.rateProperty().bind(sbSpeed.valueProperty());
        ballPane.setOnMousePressed(e -> {
            double x = e.getX();
            double y = e.getY();
            ballPane.removeBall(x,y);
        });

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Multiple bouncing balls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
