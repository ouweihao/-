package TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 服务端
public class TcpServerDemo01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1. 创建一个地址
            serverSocket = new ServerSocket(9999);

            // 2. 等待客户端连接
            socket = serverSocket.accept(); // 此时的socket就是客户端链接过来的socket

            // 3. 读取客户端的消息
            is = socket.getInputStream();

//            byte[] buffer = new byte[1024];
//            int len;
//
//            while((len = is.read(buffer)) != -1){
//                String msg = new String(buffer, 0 , len);
//                System.out.println(msg);
//            }

            // 管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            // 无论多长，因为我们输出的时候他已经拼完了
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            if (baos != null) {
                baos.close();
            }
            if (is != null) {
                is.close();
            }
            if (socket != null) {
                socket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
