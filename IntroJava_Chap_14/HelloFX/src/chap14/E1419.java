/* 
(Plot the sine and tangent functions) Write a program that plots the sine function
in red and tangent in blue, as shown in Figure 14.48c.
Hint: The Unicode for p is \u03c0. To display -2p, use Text(x, y, "–2\u03c0").
For a trigonometric function like sin(x), x is in radians. Use the following loop
to add the points to a polyline:
Polyline polyline = new Polyline();
ObservableList<Double> list = polyline.getPoints();
double scaleFactor = 50;
for (int x = −170; x <= 170; x++) {
list.add(x + 200.0);
list.add(100 – 50 * Math.sin((x / 100.0) * 2 * Math.PI));
}
*/

package chap14;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;


public class E1419 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(new SinTanGraph());
       
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Show cube function graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

class SinTanGraph extends Pane {
    private void paint() {

        Group group = new Group();

        //Create axis lines
        Line axisX = new Line(0,getHeight() * 0.8, getWidth(), getHeight() * 0.8);
        axisX.setStroke(Color.BLACK);
        Line axisY = new Line(getWidth()/2, getHeight(), getWidth()/2, getHeight() * 0.1);
        axisY.setStroke(Color.BLACK);
        Double[] arrowPointsX = new Double[] {getWidth() - 20, getHeight() * 0.8 + 10, axisX.getEndX(), axisX.getEndY(), getWidth() -20, getHeight() * 0.8 - 10};
        Polyline arrowX = new Polyline();
        arrowX.getPoints().addAll(arrowPointsX);
        arrowX.setStroke(Color.BLACK);
        Double[] arrowPointsY = new Double[] {getWidth() * 0.5 - 10, getHeight() * 0.1 + 20, axisY.getEndX(), axisY.getEndY(), getWidth() * 0.5 + 10, getHeight() * 0.1 + 20};
        Polyline arrowY = new Polyline();
        arrowY.getPoints().addAll(arrowPointsY);
        arrowY.setStroke(Color.BLACK);

        //Create text x and y
        Text tX = new Text("X");
        tX.setX(axisX.getEndX() - 20);
        tX.setY(axisX.getEndY() - 20);
        tX.setFill(Color.BLACK); 
        Text tY = new Text("Y");
        tY.setX(axisY.getEndX() - 20);
        tY.setY(axisY.getEndY() + 20);
        tY.setFill(Color.BLACK);
        
        double scaleFactor = 50;

        //Add axis lines, texts and find origin
        group.getChildren().addAll(axisX,axisY, arrowX, arrowY, tX, tY);
        double originX = axisY.getEndX();
        double originY = axisX.getEndY();
        Text p1 = new Text(originX - Math.PI * 2 * scaleFactor , originY + 20, "-2\u03c0");
        Text p2 = new Text(originX - Math.PI * scaleFactor, originY + 20, "-\u03c0");
        Text p3 = new Text(originX -10 , originY + 20, "0");
        Text p4 = new Text(originX + Math.PI * scaleFactor, originY + 20, "\u03c0");
        Text p5 = new Text(originX + 2 * Math.PI * scaleFactor, originY + 20, "2\u03c0");
        group.getChildren().addAll(p1,p2,p3,p4,p5);
        
        Polyline sinLine = new Polyline();
        sinLine.setStroke(Color.RED);
        ObservableList<Double> list1 = sinLine.getPoints();
        for (int x = -600; x <= 600; x++) {
            list1.add(x + originX);
            list1.add(originY - scaleFactor * Math.sin(x / scaleFactor));
        }

        Polyline tanLine = new Polyline();
        tanLine.setStroke(Color.GREEN);
        ObservableList<Double> list2 = tanLine.getPoints();
        for (int x = -600; x <= 600; x++) {
            list2.add(x + originX);
            list2.add(originY - scaleFactor * Math.tan(x / scaleFactor));
        }


        group.getChildren().addAll(sinLine, tanLine);

        getChildren().clear();
        getChildren().add(group);
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