package URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ouweihao/index.jsp?username=ouweihao&password=owh200066");
        System.out.println(url.getProtocol());  // 协议
        System.out.println(url.getHost());  // 主机IP
        System.out.println(url.getPort());  // 端口
        System.out.println(url.getPath());  // 文件
        System.out.println(url.getFile());  // 全路径
        System.out.println(url.getQuery());  // 参数
    }
}
