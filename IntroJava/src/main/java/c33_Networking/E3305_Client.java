/*(Send loan information in an object) Revise Exercise 33.1 for the client to send a
loan object that contains annual interest rate, number of years, and loan amount
and for the server to send the monthly payment and total payment.*/
package c33_Networking;

import c15_EventsAnimations.Loan;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class E3305_Client extends Application {
    private ObjectInputStream fromServer = null;
    private ObjectOutputStream toServer = null;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.BOTTOM_RIGHT);

        TextField tfRate = new TextField();
        TextField tfYears = new TextField();
        TextField tfAmount = new TextField();
        TextArea ta = new TextArea();
        Label lbRate = new Label("Interest rate: ", tfRate);
        Label lbYears = new Label("Number of years:", tfYears);
        Label lbAmount = new Label("Loan amount:", tfAmount);
        lbRate.setContentDisplay(ContentDisplay.RIGHT);
        lbYears.setContentDisplay(ContentDisplay.RIGHT);
        lbAmount.setContentDisplay(ContentDisplay.RIGHT);
        Button btSubmit = new Button("Submit");
        ScrollPane scP = new ScrollPane(ta);
        scP.setPrefSize(300,300);
        pane.getChildren().addAll(lbRate, lbYears, lbAmount, btSubmit, scP);

        Scene scene = new Scene(pane);
        stage.setTitle("Loan client");
        stage.setScene(scene);
        stage.show();

        btSubmit.setOnAction(e -> {
            try{
                double rates = Double.parseDouble(tfRate.getText());
                int year = Integer.parseInt(tfYears.getText());
                double amount = Double.parseDouble(tfAmount.getText());
                Loan loan = new Loan(rates, year, amount);
                toServer.writeObject(loan);
                double monthly = fromServer.readDouble();
                double totalPay = fromServer.readDouble();
                ta.appendText("Sent interest rate: " + rates + " kg\n");
                ta.appendText("Sent number of years: " + year + " m\n");
                ta.appendText("Sent loan amount: " + amount + "\n");
                ta.appendText("Receive monthly payment: " + monthly + "\n");
                ta.appendText("Receive total payment: " + totalPay + "\n\n");
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        try {
            Socket socket = new Socket("localhost", 7832);
            fromServer = new ObjectInputStream(socket.getInputStream());
            toServer = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
