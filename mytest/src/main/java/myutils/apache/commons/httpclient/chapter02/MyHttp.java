package myutils.apache.commons.httpclient.chapter02;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class MyHttp {
    public static void main(String[] args) {
        System.out.printf("111");
    }

    public void t6() {
        HttpRoutePlanner routePlanner = new HttpRoutePlanner() {
            @Override
            public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                return new HttpRoute(target, null, new HttpHost("someproxy", 8080),
                        "https".equalsIgnoreCase(target.getSchemeName()));
            }
        };
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();
    }

    public void t5() {
        SystemDefaultRoutePlanner routePlanner = new SystemDefaultRoutePlanner(
                ProxySelector.getDefault()
        );
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();
    }
    public void t4() {
        HttpHost proxy = new HttpHost("someproxy", 8080);
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();
    }

    public void t3() {
//        KeyStore myTrustStrore = null;
//        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(myTrustStrore).build();
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
    }

    public void t2() throws IOException {
        HttpClientContext clientContext = HttpClientContext.create();
        PlainConnectionSocketFactory sf = PlainConnectionSocketFactory.getSocketFactory();
        Socket socket = sf.createSocket(clientContext);
        int timeout = 1000; //ms
        HttpHost target = new HttpHost("localhost");
        InetSocketAddress remoteAddress = new InetSocketAddress(
                InetAddress.getByAddress(new byte[] {127,0,0,11}), 80);
        sf.connectSocket(timeout, socket, target, remoteAddress, null, clientContext);
    }

    ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            // Honer 'keep-alive' header
            HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String param = he.getName();
                String value= he.getValue();
                if (value != null && param.equalsIgnoreCase("timeout")){
                    try {
                        return Long.parseLong(value) * 1000;
                    } catch (NumberFormatException ignore){
                    }
                }
            }
            HttpHost target = (HttpHost) context.getAttribute(HttpClientContext.HTTP_TARGET_HOST);
            if ("www.naughty-server.com".equalsIgnoreCase(target.getHostName())){
                // Keep alive for 5 seconds only
                return 5 * 1000;
            } else {
                // Otherwise keep alive for 30 seconds
                return 30 * 1000;
            }
        }
    };
    CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(myStrategy).build();

    static class GetThread extends Thread {
        private final CloseableHttpClient httpClient;
        private final HttpContext context;
        private final HttpGet httpGet;

        public GetThread(CloseableHttpClient httpClient, HttpGet httpGet) {
            this.httpClient = httpClient;
            this.context = HttpClientContext.create();
            this.httpGet = httpGet;
        }

        @Override
        public void run() {
            try {
                CloseableHttpResponse response = httpClient.execute(httpGet, context);
                try {
                    HttpEntity entity = response.getEntity();
                } finally {
                    response.close();
                }
            } catch (ClientProtocolException e) {
                // Handle protocol errors
            } catch (IOException ex) {
                // Handle I/O errors
            }
        }
    }

    public static class IdleConnectionMonitorThread extends Thread {
        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while(!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        //Close expired connections
                        connMgr.closeExpiredConnections();
                        //Optionlly, close connections
                        //that have beean idle longer than 30 sec
                        connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException e) {
                //terminate
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this){
                notifyAll();
            }
        }
    }
}
