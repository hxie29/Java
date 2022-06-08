package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class E14L09 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Image flag = new Image("https://media.gettyimages.com/photos/rainbow-colored-lgbt-pride-flag-painted-on-a-concrete-wall-picture-id1311744217?s=612x612");
        pane.getChildren().add(new ImageView(flag));

        ImageView view2= new ImageView(flag);
        view2.setFitHeight(100);
        view2.setFitWidth(100);
        pane.getChildren().add(view2);
        
        ImageView view3 = new ImageView(flag);
        view3.setRotate(90);
        pane.getChildren().add(view3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
