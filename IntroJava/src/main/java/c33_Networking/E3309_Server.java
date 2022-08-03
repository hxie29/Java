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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E3309_Server extends Application {
    private final TextArea taServer = new TextArea();
    private final TextArea taClient = new TextArea();
    private DataOutputStream outputStream = null;
    private DataInputStream inputStream = null;

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        taClient.setEditable(false);
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
        stage.setTitle("Chat with Client (Server)");
        stage.show();

        new Thread(() -> {
            try{
                ServerSocket server = new ServerSocket(4500);
                Platform.runLater(() -> taServer.setText("Multi thread server start at " + new Date() + "\n"));

                Socket socket = server.accept();
                Platform.runLater(() -> {
                    InetAddress address = socket.getInetAddress();
                    taServer.appendText("Client joined the chat \n");
                    taServer.appendText("Client 's host name is " + address.getHostName() + "\n");
                    taServer.appendText("Client 's host address is " + address.getHostAddress() + "\nStart chatting in 2 seconds");
                });
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());

                try {
                    Thread.sleep(2000);
                    taClient.clear();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                while (true) {
                    String incomingText = inputStream.readUTF();
                    Platform.runLater(() -> taClient.setText(incomingText));
                }

            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();

        taServer.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    String str = taServer.getText();
                    outputStream.writeUTF(str);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {Application.launch(args);}
}
