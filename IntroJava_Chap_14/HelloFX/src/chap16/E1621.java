/* 
(Count-down stopwatch) Write a program that allows the user to enter time
in seconds in the text field and press the Enter key to count down the seconds,
as shown in Figure 16.45d. The remaining seconds are redisplayed
every second. When the seconds are expired, the program starts to play music
continuously.
 */
package chap16;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
/* import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media; */


public class E1621 extends Application {
   private TextField text = new TextField();
   private int number = 0 ;
   final String url = "song.mp3";
   
   @Override
   public void start(Stage primaryStage) {
       VBox pane = new VBox(10);
       pane.setAlignment(Pos.CENTER);
       
       text.setPrefColumnCount(5);
       text.setAlignment(Pos.CENTER);
       text.setFont(Font.font(50));

       Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), event -> text.setText("" + (Integer.parseInt(text.getText()) -1))));
       
       text.setOnAction(e -> {
           number = Integer.parseInt(text.getText());
           animation.setCycleCount(number); 
           animation.play();
        });
        
        pane.getChildren().addAll(text);

        /* MediaPlayer mediaPlayer = new MediaPlayer(new Media(url));
        animation.setOnFinished(event -> {
            mediaPlayer.play();
        }); */

        Scene scene = new Scene(pane, 200,100);
        primaryStage.setTitle("Count down");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
