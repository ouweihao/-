package TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) throws Exception {
        // 1.创建一个Socket链接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        // 2.创建一个输出流
        OutputStream os = socket.getOutputStream();

        // 3.读取文件流
        FileInputStream fis = new FileInputStream(new File("A梦.jpg"));

        // 4.写文件
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }

        // 通知服务器，我已经传输完成了
        socket.shutdownOutput();

        // 确定服务器接受完毕，才能够断开连接
        InputStream is = socket.getInputStream();

        byte[] buffer2 = new byte[1024];
        int len2;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len2 = is.read(buffer2)) != -1){
            baos.write(buffer, 0, len2);
        }

        System.out.println(baos.toString());

        // 5.关闭流
        fis.close();
        os.close();
        socket.close();
    }
}
