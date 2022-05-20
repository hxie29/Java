package hellofx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;


public class E14L19 extends Application {
    @Override
    public void start(Stage primaryStage) {
        

        // Using border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(new MyPolygon(), 300,200);
        primaryStage.setTitle("Show Polygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   

    class MyPolygon extends Pane {
        private void paint() {
            Polygon p = new Polygon();
            p.setFill(Color.WHITE);
            p.setStroke(Color.BLACK);
            ObservableList<Double> list = p.getPoints(); //here returns null
            double centerX = getWidth()/2, centerY = getHeight() / 2;
            double radius = Math.min(getWidth(), getHeight() * 0.4);

            for (int i = 0; i < 6; i++) {
                list.add(centerX + radius * Math.cos(2 * Math.PI / 6 * i));
                list.add(centerY - radius * Math.sin(2 * Math.PI / 6 * i));
            }
            getChildren().clear();
            getChildren().add(p);
        }

        @Override
        public void setWidth(double width) {
            super.setWidth(width);
            paint();
        }

        @Override
        public void setHeight(double height) {
            super.setHeight(height);
            paint();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
