/*(Loan server for multiple clients) Revise Programming Exercise 33.1 to write a
server for multiple clients.*/
package c33_Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E3304_Server extends Application {
    private int clientNr = -1;
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
                    Platform.runLater(() -> {
                        ta.appendText("Starting thread " + clientNr + "\n");
                        ta.appendText("Client IP address: " + socket.getInetAddress().getHostAddress() + "\n");
                    });
                    new Thread(new CountVisitor(socket, clientNr)).start();
                }
            }

            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    static class CountVisitor implements Runnable {
        private final Socket socket;
        private final int clientNumber;

        public CountVisitor(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
        }

        @Override
        public void run() {
            try {
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
                toClient.writeInt(clientNumber + 1);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
