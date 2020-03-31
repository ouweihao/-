package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// 不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 建立一个Socket
        DatagramSocket socket = new DatagramSocket();

        // 2.建立数据包
        String msg = "你好，服务器";
        // 数据， 数据的起始和终止， 目标地址， 端口
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 9000);

        // 3.发送数据包
        socket.send(packet);

        // 4、关闭流
        socket.close();
    }
}
