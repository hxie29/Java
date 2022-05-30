package chap16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E16L02 extends Application {
    protected Text text = new Text(50,50, "This is a text.");

    protected BorderPane getPane() {
        HBox paneButtons = new HBox(20);
        paneButtons.setAlignment(Pos.CENTER);
        paneButtons.setStyle("-fx-border-color: green");
        
        //Button btLeft = new Button("Left", new ImageView("https://cdn.iconscout.com/icon/premium/png-256-thumb/arrow-back-4079563-3383174.png"));
        Button btLeft = new Button("Left");
        btLeft.setContentDisplay(ContentDisplay.LEFT);
        //Button btRight = new Button("Right", new ImageView("https://cdn.iconscout.com/icon/free/png-256/right-keyboard-arrow-key-direction-30592.png"));
        Button btRight = new Button("Right");
        btRight.setContentDisplay(ContentDisplay.RIGHT);
        paneButtons.getChildren().addAll(btLeft, btRight);
    
        BorderPane pane = new BorderPane();
        pane.setBottom(paneButtons);
        pane.setCenter(new Pane(text));
    
        btLeft.setOnAction(e -> text.setX(text.getX() -10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("Button demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}