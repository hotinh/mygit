package cn.cc.myspring.rest;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


//@ComponentScan
@Configuration
public class TestConfig {
	
//	@Bean
//	public CloseableHttpClient httpClient() {
//		try {
//			return HttpClientUtils.acceptsUntrustedCertsHttpClient();
//		} catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	@Bean
//	public ClientHttpRequestFactory clientHttpRequestFactory() {
//		return new HttpComponentsClientHttpRequestFactory(httpClient());
//	}
	
//	@Bean
//	public ClientHttpRequestFactory clientHttpRequestFactory() {
//		return new TestClientHttpRequestFactory();
//	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(new TestClientHttpRequestFactory());
	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return RestClient.getClient();
//	}
	
}
