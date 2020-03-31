package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9000);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String msg = reader.readLine();

            //                                                                                         new InetSocketAddress("localhost", port)
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("localhost"), 9001);

            socket.send(packet);

            if (msg.equalsIgnoreCase("bye")){
                break;
            }
        }

        socket.close();
    }
}
