package c15_EventsAnimations;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E15L06 extends Application {
    private final TextField tfAnnualInterestRate = new TextField();
    private final TextField tfNumberOfYears = new TextField();
    private final TextField tfLoanAmount = new TextField();
    private final TextField tfMonthlyPayment = new TextField();
    private final TextField tfTotalPayment = new TextField();
    private final Button calculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("Annual Interest Rate:"), 0, 0);
        pane.add(new Label("Number of Years:"), 0, 1);
        pane.add(new Label("Loan Amount"), 0, 2);
        pane.add(new Label("Monthly Payment:"), 0, 3);
        pane.add(new Label("Total Payment"), 0, 4);
        pane.setAlignment(Pos.CENTER);

        pane.add(tfAnnualInterestRate, 1, 0);
        pane.add(tfNumberOfYears, 1, 1);
        pane.add(tfLoanAmount, 1, 2);
        pane.add(tfMonthlyPayment, 1, 3);
        pane.add(tfTotalPayment, 1, 4);
        pane.add(calculate, 1, 5);

        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setHalignment(calculate, HPos.RIGHT);
        
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);

        calculate.setOnAction(e -> calculatePayment());

        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void calculatePayment() {
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());

        Loan loan = new Loan(interest, year, loanAmount);
        tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
    }

    public static void main(String[] args ){
        launch(args);
    } 
}
