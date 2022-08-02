/* Client that sends a radius to a server and receives the area */

package c33_Networking;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class E33L02 extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setStyle("-fx-border-color: black");

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        Label lbInput = new Label("Radius: ", tf);
        lbInput.setContentDisplay(ContentDisplay.RIGHT);
        pane.setTop(lbInput);
        BorderPane.setAlignment(lbInput, Pos.CENTER);

        TextArea ta = new TextArea();
        pane.setCenter(new ScrollPane(ta));

        Scene scene = new Scene(pane, 450,200);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();


        tf.setOnAction(e -> {
            try {
                double radius = Double.parseDouble(tf.getText().trim());
                toServer.writeDouble(radius);
                double area = fromServer.readDouble();
                ta.appendText("Radius is " + radius + "\n");
                ta.appendText("Area received from the server is " + area + "\n");
            }

            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        try {
            Socket socket = new Socket("localhost", 7999);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            ta.appendText("Local port: " + socket.getLocalPort());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){Application.launch(args);}
}
