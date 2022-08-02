//IDENTIFY HOST NAME IP
package c33_Networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class E33L03 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address1 = InetAddress.getByName("www.whitehouse.gov");
        System.out.println("Host name: " + address1.getHostName());
        System.out.println("Host address: " + address1.getHostAddress());
        InetAddress address2 = InetAddress.getByName("192.0.66.168");
        System.out.println("Host name: " + address2.getHostName());
        System.out.println("Host address: " + address2.getHostAddress());
        //Host name: www.whitehouse.gov
        //Host address: 192.0.66.168
        //Host name: 192.0.66.168
        //Host address: 192.0.66.168
    }
}
