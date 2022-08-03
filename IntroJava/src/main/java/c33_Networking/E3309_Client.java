/*(Chat) Write a program that enables two users to chat. Implement one user as the
server (see Figure 33.21a) and the other as the client (see Figure 33.21b). The server
has two text areas: one for entering text, and the other (noneditable) for displaying
text received from the client. When the user presses the Enter key, the current line
is sent to the client. The client has two text areas: one (noneditable) for displaying
text from the server and the other for entering text. When the user presses the Enter
key, the current line is sent to the server. Name the client Exercise33_09Client and
the server Exercise33_09Server.*/
package c33_Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class E3309_Client extends Application {
    private final TextArea taServer = new TextArea();
    private final TextArea taClient = new TextArea();
    private DataOutputStream outputStream = null;
    private DataInputStream inputStream = null;

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        taServer.setEditable(false);
        ScrollPane serverPane = new ScrollPane(taServer);
        ScrollPane clientPane = new ScrollPane(taClient);
        serverPane.setMinSize(200,100);
        clientPane.setMinSize(200,100);
        Label lbServer = new Label("Server", serverPane);
        Label lbClient = new Label("Client", clientPane);
        lbServer.setContentDisplay(ContentDisplay.BOTTOM);
        lbClient.setContentDisplay(ContentDisplay.BOTTOM);
        pane.getChildren().addAll(lbServer, lbClient);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Chat with Server (Client)");
        stage.show();

        new Thread(() -> {
            try{
                Socket socket = new Socket("localhost", 4500);
                Platform.runLater(() -> {
                    taClient.setText("Joined chat with server at: " + new Date() + "\nStart chatting in 2 seconds");
                    try {
                        Thread.sleep(2000);
                        taClient.clear();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String incomingText = inputStream.readUTF();
                    Platform.runLater(() -> taServer.setText(incomingText));
                }

            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();

        taClient.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    String str = taClient.getText();
                    System.out.println(str);
                    outputStream.writeUTF(str);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {Application.launch(args);}

    public static String findLastLine(String text) {
        int position = text.lastIndexOf("\n");
        if (position > 0)
            return text.substring(position);
        else
            return text;
    }
}
