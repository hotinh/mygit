package cn.cc.mp.wb.configurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置
 * @author Administrator
 *
 */
@Configuration
public class RestTemplateConfigurer {
    
    static Logger logger = LoggerFactory.getLogger(RestTemplateConfigurer.class);
    
    /**
     * 总连接数
     */
    static final int MAX_TOTAL = 1000;
    
    /**
     * 同路由的并发数
     */
    static final int MAX_PER_ROUTE = 1000;
    
    /**
     * 连接超时
     */
    static final int CON_TIMEOUT = 5000;
    
    /**
     * 数据读取超时时间，即SocketTimeout
     */
    static final int RED_TIMEOUT = 5000;
    
    /**
     * 连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
     */
    static final int CON_REQ_TIMOUT = 200;
    
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        
        // 添加内容转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
//        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
 
        restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(clientFactory());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        
        logger.info("RestTemplate inited success!");
        return restTemplate;
    }
    
    @Bean
    public ClientHttpRequestFactory clientFactory() {
        HttpComponentsClientHttpRequestFactory clientFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
        
        /*底层是配置RequestConfig*/
        clientFactory.setConnectTimeout(CON_TIMEOUT);
        clientFactory.setReadTimeout(RED_TIMEOUT);
        clientFactory.setConnectionRequestTimeout(CON_REQ_TIMOUT);
        // 缓冲请求数据，默认值是true。通过POST或者PUT大量发送数据时，建议将此属性更改为false，以免耗尽内存。
        // clientFactory.setBufferRequestBody(false);
        return clientFactory;
    }
    
    @Bean
    public HttpClient httpClient() {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        
        /* 连接池配置 */
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        // 重试次数，默认是3次，没有开启
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2,true));
        // 保持长连接配置，需要在头添加Keep-Alive
        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
        
        /*底层是配置RequestConfig*/
//      RequestConfig.Builder builder = RequestConfig.custom();
//      builder.setConnectTimeout(CON_TIMEOUT);
//      builder.setSocketTimeout(RED_TIMEOUT);
//      builder.setConnectionRequestTimeout(CON_REQ_TIMOUT);
//      RequestConfig requestConfig = builder.build();
//      httpClientBuilder.setDefaultRequestConfig(requestConfig);
        
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN"));
        headers.add(new BasicHeader("Connection", "Keep-Alive"));
        
        return httpClientBuilder.build();
    }
    
}
