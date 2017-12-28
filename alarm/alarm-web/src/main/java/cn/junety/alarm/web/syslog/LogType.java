package cn.junety.alarm.web.syslog;

import cn.junety.alarm.web.common.IEnum;

public enum LogType implements IEnum {

	SELECT("查询",0),
	INSERT("新增",1),
	UPDATE("修改",2),
	DELETE("删除",3);
	
	private String name;
	private int value;
	
	private LogType(String name, int value) {
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
