package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2.监听客户端的链接
        Socket socket = serverSocket.accept(); // 阻塞式监听，会一直等待客户端连接
        // 3.获取输入
        InputStream is = socket.getInputStream();
        // 4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive2.jpg")); //管道流

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }

        // 通知客户端我接受完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接收完毕了".getBytes("utf-8"));

        // 5.关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
