/* 
(Display a pie chart) Write a program that uses a pie chart to display the percentages
of the overall market share represented by Apple, HTC, Samsung, and
Others, as shown in Figure 14.46c. Suppose that Apple takes 26 percent and is
displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
28 percent and is displayed in green, and the Others take 26 percent and are displayed
in orange. Use the Arc class to display the pies. Interested readers may
explore the JavaFX PieChart class for further study.
*/

package hellofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class E1413 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        String[] names = {"Apple", "HTC", "Samsung", "Others"};
        double[] percent = {20,26,28,26};
        Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
        pane.getChildren().add(new PieChart(names, percent, color));

        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Pie char");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

class PieChart extends Pane {
    private String[] title;
    private double[] percent;
    private Color[] color;

    public PieChart(String[] title, double[] percent, Color[] color) {
        this.title = title;
        this.percent = percent;
        this.color = color;
    }

    private void paint() {
        double begin = 0;
        double radius = 200;
        getChildren().clear();
        for (int i = 0; i < title.length; i++) {
            Text t = new Text(title[i] + " -- " + percent[i] + "%");
            t.setFill(Color.BLACK);

            Arc r = new Arc();
            r.setType(ArcType.ROUND);
            r.setFill(color[i]);
            r.centerXProperty().bind(widthProperty().divide(2));
            r.centerYProperty().bind(heightProperty().divide(2));
            r.setRadiusX(radius);
            r.setRadiusY(radius);
            r.setStartAngle(begin  / 100.0 * 360);
            r.setLength(percent[i] / 100.0 * 360);
            
            double x = radius /1.2 * Math.cos((2 * begin + percent[i]) / 2 / 100.0 * 2 * Math.PI);
            double y = radius /1.2 * Math.sin((2 * begin + percent[i]) / 2 / 100.0 * 2 * Math.PI);
            t.xProperty().bind(widthProperty().divide(2).add(x));
            t.yProperty().bind(heightProperty().divide(2).subtract(y));
            getChildren().addAll(r,t);
            
            begin += percent[i];
        }
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
        paint();
    }
    
    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
        paint();
    }
}