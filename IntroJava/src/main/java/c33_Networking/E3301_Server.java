/*(Loan server) Write a server for a client. The client sends loan information (annual
interest rate, number of years, and loan amount) to the server (see Figure 33.17a).
The server computes monthly payment and total payment, and sends them back to
the client (see Figure 33.17b). Name the client Exercise33_01Client and the server
Exercise33_01Server.*/
package c33_Networking;

import c15_EventsAnimations.Loan;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E3301_Server extends Application {
    private DataInputStream fromClient;
    private DataOutputStream toClient;

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

                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    double interestRate = fromClient.readDouble();
                    int numberOfYears = fromClient.readInt();
                    double amount = fromClient.readDouble();
                    Loan loan = new Loan(interestRate, numberOfYears, amount);
                    double monthly = loan.getMonthlyPayment();
                    double total = loan.getTotalPayment();

                    toClient.writeDouble(monthly);
                    toClient.writeDouble(total);
                    Platform.runLater(() -> {
                        ta.appendText("Received interest rate: " + interestRate + "\n");
                        ta.appendText("Received number of years: " + numberOfYears + "\n");
                        ta.appendText("Received amount: " + amount + "\n");
                        ta.appendText("Sent monthly payment: " + monthly + "\n");
                        ta.appendText("Sent total payment: " + total + "\n\n");
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
