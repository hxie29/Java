package hellofx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class E14L16 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create a Rectangel with coordinates of upper left corner, width and height
        Rectangle r1 = new Rectangle(25, 10, 60, 30);
        Rectangle r2 = new Rectangle(25, 50, 60, 30); // default a black square
        Rectangle r3 = new Rectangle(25, 90, 60, 30);
        r1.setStroke(Color.BLACK); //Default fill color (if stroke not set)
        r1.setFill(Color.WHITE); // Default stroke color (if fill not set)
        r3.setArcWidth(15);
        r3.setArcHeight(15);

        Group group = new Group();
        group.getChildren().addAll(new Text(10, 27, "r1"), r1,
                                    new Text(10, 67, "r2"), r2,
                                    new Text(10, 107, "r3"), r3);
                                    
        for (int i = 0; i < 4; i++) {
            Rectangle r = new Rectangle(100,50,100,30);
            r.setRotate(i * 360 / 8);
            r.setStroke(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            r.setFill(Color.WHITE);
            group.getChildren().add(r);
        }                                    

        // USing border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(new BorderPane(group), 250, 150);
        primaryStage.setTitle("Show Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
