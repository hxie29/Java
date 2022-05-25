package chap14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class E14L13 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        pane.setTop(getHBox());
        pane.setBottom(getVBox());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show Hbox Vbox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    private HBox getHBox() {
    HBox h = new HBox(15);
        h.setPadding(new Insets(15,15,15,15));
        h.setStyle("-fx-background-color: gold");
        h.getChildren().add(new Button("Computer Science"));
        h.getChildren().add(new Button("Chemistry"));
        return h;
    }

    private VBox getVBox(){
        VBox v = new VBox(15); // arg is spacing
        v.setPadding(new Insets(15,15,15,15));
        v.getChildren().add(new Label("Courses"));

        Label[] courses = {new Label("CS 1301"),
                            new Label("CS 1302"), new Label("CS 1303"), new Label("CS 1304")};
        for (Label e: courses) {
            //add indentation to each line
            //VBox.setMargin(e, new Insets(0,0,0,5));
            v.getChildren().add(e);
        }
        return v;                   
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
