import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;

/**
 * Created by limingda on 15/12/11.
 */
public class Test {

    public static HttpClient httpclient;

    public static void main(String[] args) {

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(1000000);
        cm.setDefaultMaxPerRoute(1000000000);
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoKeepAlive(true)
                .build();
        cm.setDefaultSocketConfig(socketConfig);
        httpclient = HttpClients.custom().setConnectionManager(cm).build();
        HttpPost post = new HttpPost("http://192.168.1.181");
        post.addHeader("Connection", "Keep-Alive");

        long time = System.currentTimeMillis();
        int i = 0;
        while (System.currentTimeMillis() - time <= 1000) {
            try {
                httpclient.execute(post);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.println(i);


    }
}
