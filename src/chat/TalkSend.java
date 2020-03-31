package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int sourcePort;
    private String toIP;
    private int toPort;

    public TalkSend(int sourcePort, String toIP, int toPort) throws Exception {
        this.sourcePort = sourcePort;
        this.toIP = toIP;
        this.toPort = toPort;

        try{
            socket = new DatagramSocket(sourcePort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try{
                String msg = reader.readLine();

                //                                                                                         new InetSocketAddress("localhost", port)
                DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, new InetSocketAddress(this.toIP, this.toPort));

                socket.send(packet);

                if (msg.equalsIgnoreCase("bye")){
                    break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
