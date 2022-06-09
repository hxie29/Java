package c16_UIMultimedia;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

public class E16L11 extends Application {
    protected Text text = new Text(50,50,"This is a text.");

    @Override
    public void start(Stage primaryStage) {

        //Orientation defalt is horizontal
        Slider slHorizontal = new Slider();
        Slider slVertical = new Slider();
        slVertical.setOrientation(Orientation.VERTICAL);

        slHorizontal.setShowTickLabels(true);
        slHorizontal.setShowTickMarks(true);
        slVertical.setShowTickLabels(true);
        slVertical.setShowTickMarks(true);
        slVertical.setValue(100);
        slHorizontal.setValue(100);

        Pane textPane = new Pane();
        textPane.getChildren().addAll(text);

        BorderPane pane = new BorderPane();
        pane.setCenter(textPane);
        pane.setBottom(slHorizontal);
        pane.setRight(slVertical);
 
        text.xProperty().bind(slHorizontal.valueProperty().divide(slHorizontal.maxProperty()).multiply(textPane.widthProperty()));
        text.yProperty().bind(slVertical.valueProperty().divide(slVertical.maxProperty()).multiply(textPane.heightProperty()));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Slider demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}