/* 
(Geometry: two circles intersect?) Write a program that enables the user to
specify the location and size of the circles, and displays whether the two circles
intersect, as shown in Figure 16.39a. Enable the user to point the mouse inside a
circle and drag it. As the circle is being dragged, the circle’s center coordinates
in the text fields are updated.
 */
package c16_UIMultimedia;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class E1608 extends Application {
    private final Text text = new Text();
    private final Circle c1 = new Circle();
    private final Circle c2 = new Circle();
    private final InputPaneCircle c1Info = new InputPaneCircle(1);
    private final InputPaneCircle c2Info = new InputPaneCircle(2);
    private final Pane figure = new Pane();

    @Override
    public void start(Stage primaryStage) {
        figure.getChildren().addAll(c1, c2);
        figure.setMinSize(400,400);

        c1.setStroke(Color.BLACK);
        c1.setFill(Color.TRANSPARENT);
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.TRANSPARENT);

        HBox inputBox0 = new HBox(10);
        inputBox0.getChildren().addAll(c1Info, c2Info);
        inputBox0.setAlignment(Pos.CENTER);

        Button btDraw = new Button("Redraw Circles");
        

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(text, figure, inputBox0, btDraw);

        btDraw.setOnAction(e -> {
            redraw();
            checkIntersect();
        });
       
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Two circles intersect?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void redraw() {
        c1Info.update();
        c2Info.update();

        c1.setCenterX(c1Info.getCenterX());
        c1.setCenterY(c1Info.getCenterY());
        c1.setRadius(c1Info.getRadius());
        
        c2.setCenterX(c2Info.getCenterX());
        c2.setCenterY(c2Info.getCenterY());
        c2.setRadius(c2Info.getRadius());
    }

    private void checkIntersect() {
        double x1 = c1.getCenterX();
        double y1 = c1.getCenterY();
        double r1 = c1.getRadius();

        double x2 = c2.getCenterX();
        double y2 = c2.getCenterY();
        double r2 = c2.getRadius();

        double distance = Math.pow(((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2)), 0.5);
        text.setText("Two circles intersection? " + ((distance < r1 + r2) ? "Yes" : "No"));
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}

class InputPaneCircle extends VBox{
    private final Label title = new Label();
    private final TextField tfCenterX = new TextField("0");
    private final TextField tfCenterY = new TextField("0");
    private final TextField tfRadius = new TextField("0");
    private double centerX = 0, centerY = 0, radius = 0;

    public InputPaneCircle() {
        this(0);
    }

    public InputPaneCircle(int n) {
        setTitle(n);
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setStyle("-fx-border-color: black");
    
        GridPane inputBox = new GridPane();
        inputBox.setHgap(10);
        inputBox.setVgap(10);
        inputBox.setAlignment(Pos.BOTTOM_LEFT);
        inputBox.add(new Label("Center X:"), 0, 0);
        inputBox.add(new Label("Center Y:"), 0, 1);
        inputBox.add(new Label("Radius:"), 0, 2);
        inputBox.add(tfCenterX, 1,0);
        inputBox.add(tfCenterY, 1,1);
        inputBox.add(tfRadius, 1,2);
        
        tfCenterX.setPrefColumnCount(4);
        tfCenterY.setPrefColumnCount(4);
        tfRadius.setPrefColumnCount(4);
        tfCenterX.setAlignment(Pos.BOTTOM_RIGHT);
        tfCenterY.setAlignment(Pos.BOTTOM_RIGHT);
        tfRadius.setAlignment(Pos.BOTTOM_RIGHT);

        getChildren().addAll(title, inputBox);
    }

    public double getRadius() {
        return radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void update() {
        centerX = Double.parseDouble(tfCenterX.getText());
        centerY = Double.parseDouble(tfCenterY.getText());
        radius = Double.parseDouble(tfRadius.getText());
    }

    private void setTitle(int n) {
        title.setText("Enter circle " + n + " info:");
    }
}
