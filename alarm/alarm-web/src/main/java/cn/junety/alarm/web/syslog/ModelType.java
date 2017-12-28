package cn.junety.alarm.web.syslog;

import cn.junety.alarm.web.common.IEnum;

public enum ModelType implements IEnum {

	USER("用户管理", 1);
	
	private String name;
	private int value;
	
	private ModelType(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}
