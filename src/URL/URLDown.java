package URL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws Exception {
        // 1. 下载地址
        URL url = new URL("https://m10.music.126.net/20200331234653/63b1656b6203fd5693194c6f8b3de8ef/yyaac/obj/wonDkMOGw6XDiTHCmMOi/1941677162/d674/a146/6699/e8b65b7574b1f94e065d312e52135d6d.m4a");

        // 2. 连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("d.m4a"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
