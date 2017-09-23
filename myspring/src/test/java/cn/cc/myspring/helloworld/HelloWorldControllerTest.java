package cn.cc.myspring.helloworld;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldControllerTest {

	@Test
	public void sayHello() {
		assertEquals("Hello World!", new HelloWorldController().sayHello());
	}
}
