// Multiple thread server
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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer extends Application {
    private final TextArea ta = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new ScrollPane(ta));
        stage.setScene(scene);
        stage.setTitle("MultiThreadServer");
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(7999);
                ta.appendText("Multi thread server start at " + new Date() + "\n");
                while (true) {
                    Socket socket = server.accept();
                    clientNo++;
                    Platform.runLater(() -> {
                        ta.appendText("Starting thread for client " + clientNo + " at " + new Date() + "\n");
                        InetAddress address = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "'s host name is " + address.getHostName() + "\n");
                        ta.appendText("Client " + clientNo + "'s host address is " + address.getHostAddress() + "\n");
                    });
                    new Thread(new HandleClient(socket)).start();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    class HandleClient implements Runnable {
        private Socket socket;

        public HandleClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    double radius = inputStream.readDouble();
                    double area = Math.PI * radius * radius;
                    outputStream.writeDouble(area);
                    Platform.runLater(() -> {
                        ta.appendText("Radius received from client is " + radius + "\n");
                        ta.appendText("Area sent to client is " + area + "\n");
                    });
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {Application.launch(args);}
}
