package cn.cc.mytest.java8.learn0403Time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class LearnTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		LocalDate.of(2017, 07, 20);
		LocalDate.parse("2017-07-20");

		DayOfWeek thursday = LocalDate.parse("2017-07-20").getDayOfWeek();
		System.out.println("周四: " + thursday);
		int twenty = LocalDate.parse("2017-07-20").getDayOfMonth();
		System.out.println("twenty: " + twenty);

		
		LocalDate firstDayOfMonth = LocalDate.parse("2017-07-20")
                .with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("这个月的第一天: " + firstDayOfMonth);
		firstDayOfMonth = firstDayOfMonth.withDayOfMonth(1);
		System.out.println("这个月的第一天: " + firstDayOfMonth);
		
		LocalDateTime.of(2017, Month.JULY, 20, 15, 18);
		LocalDateTime.parse("2017-07-20T15:18:00");
		/*
		同时`LocalDateTime`也提供了相关API来对日期和时间进行增减操作:
		```java*/
		LocalDateTime now = LocalDateTime.now();
		System.out.println("现在: " + now);
		LocalDateTime tomorrow = now.plusDays(1);
		System.out.println("明天的这个时间: " + tomorrow);
		LocalDateTime minusTowHour = now.minusHours(2);
		System.out.println("两小时前: " + minusTowHour);



	}

}
