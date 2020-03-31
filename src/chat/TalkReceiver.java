package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkReceiver implements Runnable {
    DatagramSocket socket = null;

    private int sourcePort;
    private String from;

    public TalkReceiver(int sourcePort, String from) {
        this.sourcePort = sourcePort;
        this.from = from;

        try{
            socket = new DatagramSocket(this.sourcePort);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try{
            while (true) {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);

                socket.receive(packet);

                // 断开连接
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, packet.getLength());
                System.out.println(from + ": " + receiveData);

                if (receiveData.equalsIgnoreCase("bye")) {
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        socket.close();
    }
}
