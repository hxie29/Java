/* 
(Convert numbers) Write a program that converts among decimal, hex, and binary
numbers, as shown in Figure 16.37c. When you enter a decimal value in the decimal-
value text field and press the Enter key, its corresponding hex and binary
numbers are displayed in the other two text fields. Likewise, you can enter values
in the other fields and convert them accordingly. (Hint: Use the Integer
.parseInt(s, radix) method to parse a string to a decimal and use Integer
.toHexString(decimal) and Integer.toBinaryString(decimal) to
obtain a hex number or a binary number from a decimal.)
 */
package c16_UIMultimedia;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1605 extends Application {
    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        Text tDecimal = new Text("Decimal");
        Text tHex = new Text("Hex");
        Text tBinary = new Text("Binary");
        TextField tfDec = new TextField();
        TextField tfHex = new TextField();
        TextField tfBin = new TextField();
        pane.setAlignment(Pos.CENTER_LEFT);

        pane.add(tDecimal, 0,0);
        pane.add(tHex, 0,1);
        pane.add(tBinary, 0,2);
        pane.add(tfDec, 1,0);
        pane.add(tfHex, 1,1);
        pane.add(tfBin, 1,2);
        tfDec.setAlignment(Pos.CENTER_RIGHT);
        tfHex.setAlignment(Pos.CENTER_RIGHT);
        tfBin.setAlignment(Pos.CENTER_RIGHT);

        tfDec.setOnAction( e -> {
            int number = Integer.parseInt(tfDec.getText());
            tfHex.setText(Integer.toHexString(number));
            tfBin.setText(Integer.toBinaryString(number));
        });

        tfHex.setOnAction( e -> {
            int number = Integer.parseInt(tfHex.getText(), 16);
            tfDec.setText(number + "");
            tfBin.setText(Integer.toBinaryString(number));
        });
        
        tfBin.setOnAction( e -> {
            int number = Integer.parseInt(tfBin.getText(), 2);
            tfDec.setText(number + "");
            tfHex.setText(Integer.toHexString(number));
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