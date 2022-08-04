package c33_Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChatServer {
    private final List<PrintWriter> clientWriters = new ArrayList<>();
    public static void main(String[] args) {
        new SimpleChatServer().go();
    }

    private void go() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9845));

            while (serverSocketChannel.isOpen()) {
                SocketChannel clientSocket = serverSocketChannel.accept();
                PrintWriter writer = new PrintWriter(Channels.newWriter(clientSocket, StandardCharsets.UTF_8));
                clientWriters.add(writer);
                threadPool.submit(new ClientHandler(clientSocket));
                System.out.println("Got a connection");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        SocketChannel socketChannel;
        public ClientHandler(SocketChannel clientSocket) {
            socketChannel = clientSocket;
            reader = new BufferedReader(Channels.newReader(socketChannel, StandardCharsets.UTF_8));
        }

        public void run() {
            String msg;
            try {
                while((msg = reader.readLine()) != null) {
                    System.out.println("read: " + msg);
                    tellEveryone(msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void tellEveryone(String msg) {
        for (PrintWriter writer: clientWriters) {
            writer.println(msg);
            writer.flush();
        }
    }
}
