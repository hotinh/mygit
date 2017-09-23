package cn.cc.mytest.mytime;

import java.time.*;
import java.time.format.*;

public class Test {

	public static void main(String[] args) {
		
		LocalTime time = LocalTime.now();
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		time.format(dateTimeFormatter);
		
		System.out.println(time);
		System.out.println(time.format(dateTimeFormatter));
		
		
		
		long l = System.currentTimeMillis();
		System.out.println(l);
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		
	}

}
