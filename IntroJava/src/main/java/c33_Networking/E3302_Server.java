/*(BMI server) Write a server for a client. The client sends the weight and height
for a person to the server (see Figure 33.18a). The server computes BMI (Body
Mass Index) and sends back to the client a string that reports the BMI (see Figure
33.18b). See Section 3.8 for computing BM*/
package c33_Networking;

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

public class E3302_Server extends Application {
    private DataInputStream fromClient;
    private DataOutputStream toClient;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta), 500, 500);
        stage.setTitle("BMI server");
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
                    double weight = fromClient.readDouble();
                    double height = fromClient.readDouble();
                    double bmi = weight / height / height;
                    toClient.writeDouble(bmi);
                    Platform.runLater(() -> {
                        ta.appendText("Received weight: " + weight + "\n");
                        ta.appendText("Received height: " + height + "\n");
                        ta.appendText("Sent BMI: " + bmi + "\n");
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
