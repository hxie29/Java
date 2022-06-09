package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class E14L14 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5,5, 5));
        Text t1 = new Text(20, 20, "Programming is fun");
        t1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        Text t2 = new Text(60, 60, "Programming \nis fun");
        Text t3 = new Text(0, 100, "Programming is fun");
        t3.setFill(Color.RED);
        t3.setUnderline(true);

        pane.getChildren().addAll(t1, t2, t3);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show Text");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    


    public static void main(String[] args) {
        Application.launch(args);
    }
}
