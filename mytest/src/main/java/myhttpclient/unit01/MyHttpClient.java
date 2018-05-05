package myhttpclient.unit01;

import java.io.IOException;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MyHttpClient {

    public static void main(String[] args) {
        HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                return false;
            }
            
        };
        
        CloseableHttpClient httpclient = HttpClients.custom()
                .setRetryHandler(myRetryHandler)
                .build();
        
        
        Runnable ru = () -> System.out.println();
        
        HttpRequestRetryHandler re = (IOException exception, int executionCount, HttpContext context) -> true;
    }

}
