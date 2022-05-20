package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class E14L12 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        pane.setTop(new CustomPane("Top"));
        pane.setRight(new CustomPane("Right"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPane("Left"));
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show BorderPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    class CustomPane extends StackPane {
        public CustomPane(String title) {
            getChildren().add(new Label(title));
            setStyle("-fx-border-color: red");
            setPadding(new Insets(10,10,10,10));
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
