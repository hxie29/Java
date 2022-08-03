/*(Send loan information in an object) Revise Exercise 33.1 for the client to send a
loan object that contains annual interest rate, number of years, and loan amount
and for the server to send the monthly payment and total payment.*/
package c33_Networking;

import c15_EventsAnimations.Loan;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E3305_Server extends Application {
    private ObjectInputStream fromClient;
    private ObjectOutputStream toClient;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta), 500, 500);
        stage.setTitle("Loan calculation Server");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(7832);
                Platform.runLater(() -> ta.appendText("Server started at " + new Date() +
                        ", port: " + serverSocket.getLocalPort() + "\n"));
                Socket socket = serverSocket.accept();
                Platform.runLater(() -> ta.appendText("Connected to a client at " + new Date() +
                        ", IP address: " + socket.getInetAddress().getHostAddress() + "\n"));

                fromClient = new ObjectInputStream(socket.getInputStream());
                toClient = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    Loan loan = (Loan)(fromClient.readObject());
                    toClient.writeDouble(loan.getMonthlyPayment());
                    toClient.writeDouble(loan.getTotalPayment());
                    Platform.runLater(() -> {
                        ta.appendText("Received interest rate: " + loan.getAnnualInterestRate() + "\n");
                        ta.appendText("Received number of years: " + loan.getNumberOfYears() + "\n");
                        ta.appendText("Received amount: " + loan.getLoanAmount() + "\n");
                        ta.appendText("Sent monthly payment: " + loan.getMonthlyPayment() + "\n");
                        ta.appendText("Sent total payment: " + loan.getTotalPayment() + "\n\n");
                    });
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
