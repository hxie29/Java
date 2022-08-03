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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class E3310_Server extends Application {
    private final TextArea taServer = new TextArea();
    private final Hashtable<Socket, DataOutputStream> outputStreams = new Hashtable<>();
    private ServerSocket server;

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        taServer.setEditable(false);
        taServer.setWrapText(true);
        ScrollPane serverPane = new ScrollPane(taServer);
        serverPane.setMinSize(200,100);
        Label lbServer = new Label("Server", serverPane);
        lbServer.setContentDisplay(ContentDisplay.BOTTOM);
        pane.getChildren().addAll(lbServer);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Chat with Client (Server)");
        stage.show();

        new Thread(() -> {
            try{
                server = new ServerSocket(4500);
                Platform.runLater(() -> taServer.setText("Multi thread server start at " + new Date() + "\n"));

                while (true) {
                    Socket socket = server.accept();
                    Platform.runLater(() -> {
                        InetAddress address = socket.getInetAddress();
                        taServer.appendText("Client joined the chat \n");
                        taServer.appendText("Client 's host name is " + address.getHostName() + "\n");
                        taServer.appendText("Client 's host address is " + address.getHostAddress() + "\nStart chatting in 2 seconds");
                    });
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    outputStreams.put(socket, out);
                    new ServerThread(this, socket);
                }

            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void sendToAll(String msg) {
        // Go through hashtable and send message to each output stream
        for (DataOutputStream out : outputStreams.values()) {
            try {
                out.writeUTF(msg);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class ServerThread extends Thread {
        private final Socket socket;
        private final E3310_Server server;

        public ServerThread(E3310_Server server, Socket socket) {
            this.socket = socket;
            this.server = server;
            start();
        }

        @Override
        public void run() {
            try {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());

                while (true){
                    String msg = inputStream.readUTF();
                    server.sendToAll(msg);
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {Application.launch(args);}
}
