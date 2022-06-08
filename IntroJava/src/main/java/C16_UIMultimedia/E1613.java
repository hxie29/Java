/* 
(Text viewer) Write a program that displays a text file in a text area, as shown
in Figure 16.40a. The user enters a file name in a text field and clicks the View
button; the file is then displayed in a text area.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class E1613 extends Application {
    private TextArea ta = new TextArea();
    private TextField tfAmount = new TextField();
    private TextField tfYear = new TextField();

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        ScrollPane view = new ScrollPane(ta);
        ta.setEditable(false);
        tfAmount.setPrefColumnCount(10);
        tfYear.setPrefColumnCount(6);

        Button btView = new Button("Show Table");

        HBox inputBox = new HBox();
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(new Label("Loan Amount"), tfAmount, new Label("Number of Years"), tfYear, btView);

        pane.getChildren().addAll(inputBox, view);

        btView.setOnAction(e -> {
            double amount = Double.parseDouble(tfAmount.getText());
            int year = Integer.parseInt(tfYear.getText());
            printTable(amount, year);
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("TextArea Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void printTable(double amount, int year) {
        ta.clear();
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-25s%-25s%-25s\n", "Interest Rate", "Monthly Payment", "Total Payment"));
        for (int step = 0; step <= 20; step++) {
            double annualRate = (5 + 0.25 * step);
            double monthRate = annualRate / 100 / 12;
            double monthPayment = amount * monthRate / (1 - 1 / Math.pow((1 + monthRate), (year * 12)) );
            double totalPay = monthPayment * 12 * year;
            // formatting is still not correct!
            s.append(String.format("%-5.2f%-20s%-25.2f%-25.2f\n", annualRate, "%", monthPayment, totalPay));
        }
        ta.setText(s.toString());
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}