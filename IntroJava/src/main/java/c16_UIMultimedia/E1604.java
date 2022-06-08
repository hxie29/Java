/* 
(Create a Celsius/Fahrenheit converter) Write a program that converts Celsius
and Fahrenheit, as shown in Figure 16.37b. If you enter a value in the Celsius
text field and press the Enter key, the corresponding Fahrenheit measurement is
displayed in the Fahrenheit text field. Likewise, if you enter a value in the Fahrenheit
text field and press the Enter key, the corresponding Celsius measurement
is displayed in the Celsius text field.
 */
package chap16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1604 extends Application {
    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        Text celsius = new Text("Celsius");
        Text frah = new Text("Frahrenheit");
        TextField tfC = new TextField();
        TextField tfF = new TextField();
        pane.setAlignment(Pos.CENTER_LEFT);

        pane.add(celsius, 0,0);
        pane.add(frah, 0,1);
        pane.add(tfC, 1,0);
        pane.add(tfF, 1,1);
        tfC.setAlignment(Pos.CENTER_RIGHT);
        tfF.setAlignment(Pos.CENTER_RIGHT);
        tfF.setEditable(false);

        tfC.setOnAction( e -> {
            int number = Integer.parseInt(tfC.getText());
            tfF.setText("" + (number * 1.8 + 32));
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Label with graphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}