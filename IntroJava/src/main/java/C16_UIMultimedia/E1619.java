/* 
(Control a group of fans) Write a program that displays three fans in a group
with control buttons to start and stop all of them, as shown in Figure 16.44.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import chap15.FanPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class E1619 extends Application {
    private ControlFan[] fans = new ControlFan[3];
    private Button btStartAll = new Button("Start All");
    private Button btStopAll = new Button("Stop All");

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        GridPane fanGrid = new GridPane();
        fanGrid.setHgap(10);
        fanGrid.setAlignment(Pos.CENTER);
        for (int i = 0; i < fans.length; i++) {
            fans[i] = new ControlFan();
            fanGrid.add(fans[i], i, 0);
        }
        
        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(btStartAll, btStopAll);

        btStartAll.setOnAction(e -> {
            for (int i = 0; i < fans.length; i++) {
                fans[i].play();
            }
        });

        btStopAll.setOnAction(e -> {
            for (int i = 0; i < fans.length; i++) {
                fans[i].stop();
            }
        });

        pane.getChildren().addAll(fanGrid, controlPanel);

        Scene scene = new Scene(pane, 1000,800);
        primaryStage.setTitle("Three fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}

class ControlFan extends VBox {
    private FanPane fan = new FanPane();
    private Button btPause = new Button("Pause");
    private Button btResume = new Button("Resume");
    private Button btReverse = new Button("Reverse");
    private Slider sld = new Slider();
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e -> fan.spinBlades()));

    public ControlFan() {
        setStyle("-fx-border-color: black");
        HBox topPanel = new HBox(10);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.getChildren().addAll(btPause, btResume, btReverse);

        setSpacing(10);
        getChildren().addAll(topPanel, fan, sld);

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fan.changeDirection());
        sld.valueProperty().addListener(ov -> fan.setSpeed((int)(50 * sld.getValue() * 1.0 / sld.getMax() + 10)));
    }

    public void play() {
        animation.play();
    }

    public void stop() {
        animation.stop();
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
    }
    
    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
    }

}