/* Server that receives a radius from client and send back the area*/
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

public class E33L01 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(7865);
                Platform.runLater(() -> ta.appendText("Server started at " + new Date() + "\n"));
                    //Listen for a connection request
                Socket socket = server.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    double radius = inputStream.readDouble();
                    double area = Math.PI * radius * radius;
                    outputStream.writeDouble(area);
                    Platform.runLater(() -> {
                        ta.appendText("Radius received from client: " + radius + "\n");
                        ta.appendText("Area is: " + area + "\n");
                    });
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static void main(String[] args){Application.launch(args);}
}
