package myrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHttp {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestHttp.class);

	public static void main(String[] args) {

		String url = "http://192.168.0.113:8088/alarms";
		String s = HttpClientUtils.doGet(url);
		LOGGER.info(s);
	}

}
