// Multiple thread server
package c33_Networking;

import c17_BinaryIO.AddressBook;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class E3306_Server extends Application implements E3306_Constants{
    private final TextArea ta = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new ScrollPane(ta));
        stage.setScene(scene);
        stage.setTitle("Address book server");
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(PORT);
                ta.appendText("Multi thread address book server start at " + new Date() + "\n");
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
    static class HandleClient implements Runnable {
        private final Socket socket;

        private final ArrayList<AddressBook> book = new ArrayList<>();
        private int index = -1;

        public HandleClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
                while (true) {
                    int service = fromClient.readInt();
                    switch (service){
                        case ADD -> {
                            book.add((AddressBook) fromClient.readObject());
                            index++;
                        }
                        case FIRST -> {
                            if (book.size()> 0) toClient.writeObject(book.get(0));
                            else toClient.writeObject(null);
                        }
                        case NEXT -> {
                            if (index + 1 < book.size())
                                toClient.writeObject(book.get(++index));
                            else toClient.writeObject(null);
                        }
                        case PREVIOUS -> {
                            if (index > 0) toClient.writeObject(book.get(--index));
                            else toClient.writeObject(null);
                        }
                        case LAST -> {
                            if (book.size() > 0) toClient.writeObject(book.get(book.size() -1));
                            else toClient.writeObject(null);
                        }
                    }
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {Application.launch(args);}
}
