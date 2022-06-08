/* 
Cosine pane used in E1524
}
*/

package chap15;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;


public class CosineGraphPane extends Pane {
    private double scaleFactor = 50;
    private Polyline cosineLine = new Polyline();

    public CosineGraphPane() {

    }

    public Polyline getCosineLine() {
        return cosineLine;
    }

    private void paint() {
        scaleFactor = getWidth() / 8 / Math.PI;

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
        
        cosineLine.setStroke(Color.RED);
        int leftPoint = (int)(getWidth() / 2 / 0.9);
        ObservableList<Double> list1 = cosineLine.getPoints();
        for (int x = -leftPoint; x <= leftPoint; x++) {
            list1.add(x + originX);
            list1.add(originY - scaleFactor * Math.cos(x / scaleFactor));
        }

        group.getChildren().add(cosineLine);

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