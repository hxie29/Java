/*(Loan server) Write a server for a client. The client sends loan information (annual
interest rate, number of years, and loan amount) to the server (see Figure 33.17a).
The server computes monthly payment and total payment, and sends them back to
the client (see Figure 33.17b). Name the client Exercise33_01Client and the server
Exercise33_01Server.*/
package c33_Networking;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class E3301_Client extends Application {
    private DataInputStream fromServer;
    private DataOutputStream toServer;

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
                toServer.writeDouble(rates);
                toServer.writeInt(year);
                toServer.writeDouble(amount);
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
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
