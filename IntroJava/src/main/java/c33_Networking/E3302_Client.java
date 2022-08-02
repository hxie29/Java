/*(BMI server) Write a server for a client. The client sends the weight and height
for a person to the server (see Figure 33.18a). The server computes BMI (Body
Mass Index) and sends back to the client a string that reports the BMI (see Figure
33.18b). See Section 3.8 for computing BM*/
package c33_Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E3302_Client extends Application {
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.BOTTOM_RIGHT);

        TextField tfWeight = new TextField();
        TextField tfHeight = new TextField();
        TextArea ta = new TextArea();
        Label lbWeight = new Label("Weight (kg): ", tfWeight);
        Label lbHeight = new Label("Height (m): ", tfHeight);
        lbWeight.setContentDisplay(ContentDisplay.RIGHT);
        lbHeight.setContentDisplay(ContentDisplay.RIGHT);
        Button btSubmit = new Button("Submit");
        ScrollPane scP = new ScrollPane(ta);
        scP.setPrefSize(300,300);
        pane.getChildren().addAll(lbWeight, lbHeight, btSubmit, scP);

        Scene scene = new Scene(pane);
        stage.setTitle("BMI client");
        stage.setScene(scene);
        stage.show();

        btSubmit.setOnAction(e -> {
            try{
                double weight = Double.parseDouble(tfWeight.getText());
                double height = Double.parseDouble(tfHeight.getText());
                toServer.writeDouble(weight);
                toServer.writeDouble(height);
                double bmi = fromServer.readDouble();
                ta.appendText("Sent weight: " + weight + " kg\n");
                ta.appendText("Sent height: " + height + " m\n");
                ta.appendText("Received BMI: " + bmi + "\n");
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
