/*(Loan server for multiple clients) Revise Programming Exercise 33.1 to write a
server for multiple clients.*/
package c33_Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class E3304_Client extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        Label lb = new Label();
        pane.getChildren().add(lb);
        Scene scene = new Scene(pane, 500, 250);
        stage.setTitle("Count visitor client");
        stage.setScene(scene);
        stage.show();

        try {
            Socket socket = new Socket("localhost", 7832);
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            int number = fromServer.readInt();
            Platform.runLater(() -> lb.setText("You are visitor " + number));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
