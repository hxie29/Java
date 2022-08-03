/*(Multiple client chat) Write a program that enables any number of clients to chat.
Implement one server that serves all the clients, as shown in Figure 33.22. Name
the client Exercise33_10Client and the server Exercise33_10Server.*/
package c33_Networking;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class E3310_Client extends Application {
    private final TextArea taServer = new TextArea();
    private final TextField tfClient = new TextField();
    private final TextField tfName = new TextField();
    private String name;
    private DataOutputStream outputStream = null;
    private DataInputStream inputStream = null;

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        taServer.setEditable(false);
        ScrollPane serverPane = new ScrollPane(taServer);
        serverPane.setMinSize(200,100);
        Label lbServer = new Label(" ", serverPane);
        Label lbName = new Label("Name", tfName);
        Label lbClient = new Label("Enter text", tfClient);
        lbServer.setContentDisplay(ContentDisplay.BOTTOM);
        lbClient.setContentDisplay(ContentDisplay.RIGHT);
        lbName.setContentDisplay(ContentDisplay.RIGHT);
        pane.getChildren().addAll(lbName, lbClient, lbServer);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Chat with multiple people (Client)");
        stage.show();

        try {
            Socket socket = new Socket("localhost", 4500);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(this::receiving).start();
            //receiving text and sending text run on parallel threads
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        tfName.setOnAction(e -> name = tfName.getText().trim());

        tfClient.setOnAction(e -> {
            try {
                outputStream.writeUTF(name + ": " + tfClient.getText().trim());
                tfClient.setText("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void receiving() {
        try{
            while (true) {
                String incomingText = inputStream.readUTF();
                taServer.appendText(incomingText + "\n");
            }
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {Application.launch(args);}
}
