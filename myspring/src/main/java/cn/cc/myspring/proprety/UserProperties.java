package cn.cc.myspring.proprety;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class UserProperties {

	@Value("${user.name}")
	private String name;
	@Value("${user.age}")
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserProperties [name=" + name + ", age=" + age + "]";
	}
	
}
