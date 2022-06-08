package chap16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class E16L14 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button playButton = new Button(">");
        Button rewind = new Button("<<");
        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);

        HBox controlPanel = new HBox(10);
        controlPanel.getChildren().addAll(playButton, rewind, new Label("Volume:") ,slVolume);

        BorderPane pane = new BorderPane();
        pane.setBottom(controlPanel);

        try {
            Media pianoVideo = new Media("http://liveexample.pearsoncmg.com/common/sample.mp4");
            MediaPlayer player = new MediaPlayer(pianoVideo);
            MediaView view = new MediaView(player);
    
            playButton.setOnAction(e -> {
                if (playButton.getText().equals(">")) {
                    player.play();
                    playButton.setText("||");
                }
                else {
                    player.pause();
                    playButton.setText(">");
                }
            });
            rewind.setOnAction(e -> player.seek(Duration.ZERO));
            player.volumeProperty().bind(slVolume.valueProperty().divide(100));
            pane.setCenter(view);
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Media demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}