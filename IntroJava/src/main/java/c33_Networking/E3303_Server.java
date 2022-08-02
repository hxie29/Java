/*(Loan server for multiple clients) Revise Programming Exercise 33.1 to write a
server for multiple clients.*/
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

public class E3303_Server extends Application {
    private int clientNr = 0;
    private final TextArea ta = new TextArea();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new ScrollPane(ta), 500, 500);
        stage.setTitle("Loan calculation Server");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(7832);
                Platform.runLater(() -> ta.appendText("Server started at " + new Date() +
                        ", port: " + serverSocket.getLocalPort() + "\n"));
                while (true) {
                    Socket socket = serverSocket.accept();
                    clientNr++;
                    Platform.runLater(() -> ta.appendText("Connected to a client " + clientNr + " at " + new Date() +
                            ", IP address: " + socket.getInetAddress().getHostAddress() + "\n"));
                    new Thread(new HandleLoan(socket, clientNr)).start();
                }
            }

            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    class HandleLoan implements Runnable {
        private final Socket socket;
        private final int clientNumber;

        public HandleLoan(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
        }

        @Override
        public void run() {
            try {
                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

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
                        ta.appendText("From client " + clientNumber + ": \n");
                        ta.appendText("Received interest rate: " + interestRate + "\n");
                        ta.appendText("Received number of years: " + numberOfYears + "\n");
                        ta.appendText("Received amount: " + amount + "\n");
                        ta.appendText("Sent monthly payment: " + monthly + "\n");
                        ta.appendText("Sent total payment: " + total + "\n\n");
                    });
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
