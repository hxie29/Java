package c16_UIMultimedia;

import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16L07 extends Application {
    @Override
    public void start(Stage primaryStage) {

        DescriptionPane descriptionPane = new DescriptionPane();

        descriptionPane.setTitle("LGBTQ+");
        descriptionPane.setDescription("This is a pride flag....");
        descriptionPane.setImageView(new ImageView("http://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/rainbow-flag.png"));


        Scene scene = new Scene(descriptionPane, 450, 200);
        primaryStage.setTitle("TextArea Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}