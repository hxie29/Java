package c14_JavaFX;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

class Octagon extends Pane {
    private void paint() {

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double width = Math.min(getWidth(), getHeight()) * 0.8;
        double side = width / (1 + Math.pow(2, 0.5));

        Double[] p1 = new Double[16];

        //Point 1
        p1[0] = centerX + width / 2;
        p1[1] = centerY + side / 2;
        //Point 2
        p1[2] = p1[0];
        p1[3] = p1[1] - side;

        //Point 3
        p1[4] = centerX + side / 2;
        p1[5] = centerY - width / 2;
        //Point 4
        p1[6] = p1[4] - side;
        p1[7] = p1[5];

        //Point 5
        p1[8] = centerX - width / 2;
        p1[9] = p1[3];
        //Point 6
        p1[10] = p1[8];
        p1[11] = p1[1];

        //Point 7
        p1[12] = p1[6];
        p1[13] = centerY + width / 2;

        //Point 8
        p1[14] = p1[4];
        p1[15] = p1[13];

        Polygon t1 = new Polygon();
        t1.getPoints().addAll(p1);
        t1.setStroke(Color.RED);
        t1.setFill(Color.RED);

        getChildren().clear();
        getChildren().add(t1);
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
