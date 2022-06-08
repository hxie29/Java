package chap15;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MapPane extends BorderPane {
    private Group group = new Group();

    MapPane() {
        ArrayList<ArrayList<Point2D>> points = getPoint();
        //Put points into polygons
        for (int i = 0; i < points.size(); i++) {
            Polygon p = new Polygon();
            for (int j = 0; j < points.get(i).size(); j++) {
                p.getPoints().addAll(points.get(i).get(j).getX(), -1 * points.get(i).get(j).getY());
            }
            p.setFill(Color.WHITE);
            p.setStroke(Color.BLACK);
            p.setStrokeWidth(0.1);

            p.setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.PRIMARY) p.setFill(Color.RED);
                else p.setFill(Color.BLUE);
            });
            group.getChildren().add(p);
        }
        group.setScaleX(10);
        group.setScaleY(10);
        //Recenter after adding one state on the map
        this.setCenter(group);
    }

    public void enlarge() {
        group.setScaleX(1.1 * group.getScaleX());
        group.setScaleY(1.1 * group.getScaleY());
    }

    public void shrink() {
        group.setScaleX(group.getScaleX() / 1.1 );
        group.setScaleY(group.getScaleY() / 1.1);
    }
    
    //Get coordinates from file
    private ArrayList<ArrayList <Point2D> > getPoint() {
        ArrayList<ArrayList<Point2D>> list = new ArrayList<>();

        try (Scanner input = new Scanner(new URL("https://liveexample.pearsoncmg.com/data/usmap.txt").openStream())) {
            while (input.hasNext()) {
                String s = input.next();
                if (Character.isAlphabetic(s.charAt(0))) {
                    list.add(new ArrayList<>());
                }
                else {
                    Scanner scanPoints = new Scanner(s);
                    double y = scanPoints.nextDouble();
                    double x = scanPoints.nextDouble();
                    list.get(list.size() - 1).add(new Point2D(x, y));
                }
            }
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
}
