package c33_Networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class E3300 {
    public static void main(String[] args) {
        try {
            SocketAddress socketAddress = new InetSocketAddress("localhost", 8000);
            SocketChannel socketChannel = SocketChannel.open(socketAddress);
            Writer writer = Channels.newWriter(socketChannel, StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(writer);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
