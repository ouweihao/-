package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiverDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9001);

        while (true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);

            socket.receive(packet);

            // 断开连接
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, packet.getLength());
            System.out.println(receiveData);

            if (receiveData.equalsIgnoreCase("bye")){
                break;
            }
        }

        socket.close();
    }
}
