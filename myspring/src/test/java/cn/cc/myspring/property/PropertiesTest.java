package cn.cc.myspring.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import cn.cc.myspring.proprety.HomeProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

	@Test
	public void getHomeProperties() {
		System.out.println("---");
	}
}
