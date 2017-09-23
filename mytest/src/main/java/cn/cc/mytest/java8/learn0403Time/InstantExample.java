package cn.cc.mytest.java8.learn0403Time;

import java.time.*;

import org.mockito.internal.verification.Times;

public class InstantExample {

	public static void main(String[] args) {
		
		//Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp=" + timestamp);
		
		//Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time=" + specificTime);
		
		//Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);

	}

}
