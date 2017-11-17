package test;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@Configuration
public class TestConfiguration {
        public TestConfiguration(){
            System.out.println("spring容器启动初始化。。。");
        }


    //@Bean注解注册bean,同时可以指定初始化和销毁方法
    @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
//    @Bean
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }
}
