/* (Draw a detailed clock) Modify the ClockPane class in Section 14.12 to draw
the clock with more details on the hours and minutes, as shown in Figure 14.52a.
 */
package c14_JavaFX;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;


public class E1427 extends Application {
    @Override
    public void start(Stage primaryStage) {
        DetailedClockPane clock = new DetailedClockPane();
        String time ="Time: " + clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSeconds();
        Label timeLabel = new Label(time);

        BorderPane pane = new BorderPane();
        pane.setBottom(timeLabel);
        pane.setCenter(clock);
        BorderPane.setAlignment(timeLabel, Pos.TOP_CENTER);
        

        // Using border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(pane, 300,200);
        primaryStage.setTitle("Show Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   

    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

