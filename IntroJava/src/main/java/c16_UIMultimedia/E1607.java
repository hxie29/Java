package c16_UIMultimedia;/*
(Set clock time) Write a program that displays a clock and sets the time with the
input from three text fields, as shown in Figure 16.38b. Use the ClockPane in
Listing 14.21. Resize the clock to the center of the pane.
 */
import c14_JavaFX.ClockPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class E1607 extends Application {
    private final ClockPane clock = new ClockPane();
    
    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        HBox paneInput = new HBox(10);
        paneInput.setAlignment(Pos.CENTER);
        paneInput.setPadding(new Insets(5,5,5,5));
        paneInput.setStyle("-fx-border-color: green");

        TextField hour = new TextField();
        hour.setPrefColumnCount(5);
        TextField minute = new TextField();
        minute.setPrefColumnCount(5);
        TextField second = new TextField();
        second.setPrefColumnCount(5);
        paneInput.getChildren().addAll(new Label("Hour"), hour,
                                     new Label("Minute"), minute, new Label("Second"), second);
                
        pane.setBottom(paneInput);
        pane.setCenter(clock);

        hour.setOnAction(e -> clock.setHour(Integer.parseInt(hour.getText())));
        minute.setOnAction(e -> clock.setMinute(Integer.parseInt(minute.getText())));
        second.setOnAction(e -> clock.setSeconds(Integer.parseInt(second.getText())));
       
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Stackpane with shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    public static void main(String[] args ){
        launch(args);
    }
    
}
