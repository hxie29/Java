package c33_Networking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
    private ObjectOutputStream outputStream = null;
    private ObjectInputStream inputStream = null;

    public static void main(String[] args) {
        new StudentServer();
    }

    public StudentServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started");
            outputStream = new ObjectOutputStream(new FileOutputStream("StudentAddress.dat", true));
            while (true) {
                Socket socket = serverSocket.accept();
                inputStream = new ObjectInputStream(socket.getInputStream());
                Object ob = inputStream.readObject();
                outputStream.writeObject(ob);
                System.out.println("A student object is stored from client IP: " + socket.getInetAddress().getHostAddress());
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        finally {
            try {
                inputStream.close();
                outputStream.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
