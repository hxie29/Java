package hellofx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class E14L18 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Arc a1 = new Arc(150,100,80,80,30,35);
        Arc a2 = new Arc(150,100,80,80,30+90,35);
        Arc a3 = new Arc(150,100,80,80,30+180,35);
        Arc a4 = new Arc(150,100,80,80,30+270,35);

        a1.setFill(Color.RED);
        a2.setFill(Color.WHITE);
        a2.setStroke(Color.BLACK);
        a3.setFill(Color.WHITE);
        a3.setStroke(Color.BLACK);
        a4.setFill(Color.GREEN);
        a4.setStroke(Color.BLACK);

        a1.setType(ArcType.ROUND);
        a2.setType(ArcType.OPEN);
        a3.setType(ArcType.CHORD);
        a4.setType(ArcType.CHORD);

        Group group = new Group();
        group.getChildren().addAll(a1,a2,a3,a4);

        // Using border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(new BorderPane(group), 300,200);
        primaryStage.setTitle("Show Arc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   

    public static void main(String[] args) {
        Application.launch(args);
    }
}
