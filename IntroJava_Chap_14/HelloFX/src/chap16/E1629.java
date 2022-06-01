/* 
(Display a calendar) Write a program that displays the calendar for the current
month. You can use the Prior and Next buttons to show the calendar of the
previous or next month. Display the dates in the current month in black and
display the dates in the previous month and next month in gray, as shown in
Figure 16.48.
 */
package chap16;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class E1629 extends Application {
    private CalendarPane calendar = new CalendarPane();
    private Button btPrior = new Button("Prior");
    private Button btNext = new Button("Next");
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(btPrior, btNext);

        pane.setCenter(calendar);
        pane.setBottom(controlPanel);

        btPrior.setOnAction(e -> calendar.prior());
        btNext.setOnAction(e -> calendar.next());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Four cars with speed control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
