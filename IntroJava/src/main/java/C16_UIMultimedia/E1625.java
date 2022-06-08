/* 
(Racing cars) Write a program that simulates four cars racing, as shown in
Figure 16.47b. You can set the speed for each car, with a maximum of 100.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import chap15.CarPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class E1625 extends Application {
    private CarPane car1 = new CarPane();
    private CarPane car2 = new CarPane();
    private CarPane car3 = new CarPane();
    private CarPane car4 = new CarPane();

    private TextField tf1 = new TextField();
    private TextField tf2 = new TextField();
    private TextField tf3 = new TextField();
    private TextField tf4 = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        car1.setStyle("-fx-border-color: black");
        car2.setStyle("-fx-border-color: black");
        car3.setStyle("-fx-border-color: black");
        car4.setStyle("-fx-border-color: black");

        car1.play();
        car2.play();
        car3.play();
        car4.play();

        tf1.setPrefColumnCount(3);
        tf2.setPrefColumnCount(3);
        tf3.setPrefColumnCount(3);
        tf4.setPrefColumnCount(3);
        tf1.setText(""+car1.getSpeed());
        tf2.setText(""+car2.getSpeed());
        tf3.setText(""+car3.getSpeed());
        tf4.setText(""+car4.getSpeed());
        

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        Label lbCar1 = new Label("Car 1: ", tf1);
        Label lbCar2 = new Label("Car 2: ", tf2);
        Label lbCar3 = new Label("Car 3: ", tf3);
        Label lbCar4 = new Label("Car 4: ", tf4);
        lbCar1.setContentDisplay(ContentDisplay.RIGHT);
        lbCar2.setContentDisplay(ContentDisplay.RIGHT);
        lbCar3.setContentDisplay(ContentDisplay.RIGHT);
        lbCar4.setContentDisplay(ContentDisplay.RIGHT);
        controlPanel.getChildren().addAll(lbCar1, lbCar2, lbCar3, lbCar4);

        pane.getChildren().addAll(controlPanel, car1, car2, car3, car4);
        
        tf1.setOnAction(e -> car1.setSpeed(Integer.parseInt(tf1.getText())));
        tf2.setOnAction(e -> car2.setSpeed(Integer.parseInt(tf2.getText())));
        tf3.setOnAction(e -> car3.setSpeed(Integer.parseInt(tf3.getText())));
        tf4.setOnAction(e -> car4.setSpeed(Integer.parseInt(tf4.getText())));

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Four cars with speed control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
