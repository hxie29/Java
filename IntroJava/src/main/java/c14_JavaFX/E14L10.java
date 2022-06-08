package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

public class E14L10 extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane(200,250);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setOrientation(Orientation.HORIZONTAL);

        pane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));

        TextField tfMI = new TextField();
        tfMI.setPrefColumnCount(10);
        pane.getChildren().addAll(tfMI, new Label("Last Name:"), new TextField());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show FlowPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
