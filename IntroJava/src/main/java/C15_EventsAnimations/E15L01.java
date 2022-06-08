package chap15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E15L01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);

        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        pane.getChildren().addAll(ok, cancel);

        OkHandler handler1 = new OkHandler();
        CancelHandler handler2 =  new CancelHandler();
        ok.setOnAction(handler1);
        cancel.setOnAction(handler2);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Handle Event Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}

class OkHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("OK button clicked");
    }
}
class CancelHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("Cancel button clicked");
    }
}
