/* 
(Geometry: two Rectangles intersect?) Write a program that enables the user to
specify the location and size of the Rectangles, and displays whether the two Rectangles
intersect, as shown in Figure 16.39a. Enable the user to point the mouse inside a
Rectangle and drag it. As the Rectangle is being dragged, the Rectangle’s center coordinates
in the text fields are updated.
 */
package chap16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class E1609 extends Application {
    private Text text = new Text();
    private Rectangle r1 = new Rectangle();
    private Rectangle r2 = new Rectangle();
    private InputPaneRectangle r1Info = new InputPaneRectangle(1);
    private InputPaneRectangle r2Info = new InputPaneRectangle(2);
    private Pane figure = new Pane();

    @Override
    public void start(Stage primaryStage) {
        figure.getChildren().addAll(r1, r2);
        figure.setMinSize(400,400);

        r1.setStroke(Color.BLACK);
        r1.setFill(Color.TRANSPARENT);
        r2.setStroke(Color.BLACK);
        r2.setFill(Color.TRANSPARENT);

        HBox inputBox0 = new HBox(10);
        inputBox0.setAlignment(Pos.CENTER);
        inputBox0.getChildren().addAll(r1Info, r2Info);

        Button btDraw = new Button("Redraw Rectangles");
        

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(text, figure, inputBox0, btDraw);

        btDraw.setOnAction(e -> {
            redraw();
            checkIntersect();
        });
       
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Two Rectangles intersect?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void redraw() {
        r1Info.update();
        r2Info.update();
        
        r1.setX(r1Info.getX());
        r1.setY(r1Info.getY());
        r1.setWidth(r1Info.getRWidth());
        r1.setHeight(r1Info.getRHeight());
        
        r2.setX(r2Info.getX());
        r2.setY(r2Info.getY());
        r2.setWidth(r2Info.getRWidth());
        r2.setHeight(r2Info.getRHeight());
    }

    private void checkIntersect() {
        boolean intersect = false;
        double x1 = r1.getX();
        double y1 = r1.getY();
        double w1 = r1.getWidth();
        double h1 = r1.getHeight();
        
        double x2 = r2.getX();
        double y2 = r2.getY();
        double w2 = r2.getWidth();
        double h2 = r2.getHeight();
        
        if (r1.contains(x2,y2) || r1.contains(x2 + w2, y2) || r1.contains(x2, y2 + h2) || r1.contains(x2+w2, y2 + h2)) intersect = true;
        if (r2.contains(x1,y1) || r2.contains(x1 + w1, y1) || r2.contains(x1, y1 + h1) || r2.contains(x1+w1, y1 + h1)) intersect = true;
        
        text.setText("Two Rectangles intersection? " + ((intersect) ? "Yes" : "No"));
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}

class InputPaneRectangle extends VBox{
    private Label title = new Label();
    private TextField tfX = new TextField("0");
    private TextField tfY = new TextField("0");
    private TextField tfWidth = new TextField("0");
    private TextField tfHeight = new TextField("0");
    private double[] info = new double[4];

    public InputPaneRectangle() {
        this(0);
    }

    public InputPaneRectangle(int n) {
        setTitle(n);
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setStyle("-fx-border-color: black");
    
        GridPane inputBox = new GridPane();
        inputBox.setHgap(10);
        inputBox.setVgap(10);
        inputBox.setAlignment(Pos.BOTTOM_LEFT);
        inputBox.add(new Label("X:"), 0, 0);
        inputBox.add(new Label("Y:"), 0, 1);
        inputBox.add(new Label("Width:"), 0, 2);
        inputBox.add(new Label("Height:"), 0, 3);
        inputBox.add(tfX, 1,0);
        inputBox.add(tfY, 1,1);
        inputBox.add(tfWidth, 1,2);
        inputBox.add(tfHeight, 1,3);
        
        tfX.setPrefColumnCount(4);
        tfY.setPrefColumnCount(4);
        tfWidth.setPrefColumnCount(4);
        tfHeight.setPrefColumnCount(4);
        tfX.setAlignment(Pos.BOTTOM_RIGHT);
        tfY.setAlignment(Pos.BOTTOM_RIGHT);
        tfWidth.setAlignment(Pos.BOTTOM_RIGHT);
        tfHeight.setAlignment(Pos.BOTTOM_RIGHT);

        getChildren().addAll(title, inputBox);
    }

    public double getX() {
        return info[0];
    }
    
    public double getY() {
        return info[1];
    }
    
    public double getRWidth() {
        return info[2];
    }

    public double getRHeight() {
        return info[3];
    }

    public void update() {
        info[0] = Double.parseDouble(tfX.getText());
        info[1] = Double.parseDouble(tfY.getText());
        info[2] = Double.parseDouble(tfWidth.getText());
        info[3] = Double.parseDouble(tfHeight.getText());
    }

    private void setTitle(int n) {
        title.setText("Enter Rectangle " + n + " info:");
    }
}
