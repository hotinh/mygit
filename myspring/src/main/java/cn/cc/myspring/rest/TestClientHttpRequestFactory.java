package cn.cc.myspring.rest;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;

public class TestClientHttpRequestFactory implements ClientHttpRequestFactory, DisposableBean {

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
