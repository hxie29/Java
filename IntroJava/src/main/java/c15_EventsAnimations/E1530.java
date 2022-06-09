/* 
(Slide show) Twenty-five slides are stored as image files (slide0.jpg, slide1.
jpg, . . . , slide24.jpg) in the image directory downloadable along with the
source code in the book. The size of each image is 800 * 600. Write a program
that automatically displays the slides repeatedly. Each slide is shown for two
seconds. The slides are displayed in order. When the last slide finishes, the first
slide is redisplayed, and so on. Click to pause if the presentation is currently playing.
Click to resume if the presentation is currently paused.
 */
package c15_EventsAnimations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation.Status;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;

public class E1530 extends Application {
    private final Image[] images = new Image[25];
    private final ImageView view = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i <= 24; i++) {
            images[i] = new Image("image\side" + i + ".jpg");
        }
        view.setImage(images[0]);
        view.setFitHeight(600);
        view.setFitWidth(800);

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setCenter(view);

        Timeline pre = new Timeline(new KeyFrame(Duration.seconds(2), e -> changeSlide()));
        pre.setCycleCount(Timeline.INDEFINITE);
        pre.play();
        
        pane.setOnMouseClicked(e -> {
            if (pre.getStatus().equals(Status.PAUSED)) pre.play();
            else pre.pause();
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Presentation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeSlide() {
        Image current = view.getImage();
        int index = 0;
        for (int i = 0; i < images.length; i++) {
            if (current.equals(images[i])) {
                index = i;
                break;
            }
        }
        view.setImage((index < 24) ? images[index+1] : images[0]);
    }
    
    public static void main(String[] args ){
        launch(args);
    }
}