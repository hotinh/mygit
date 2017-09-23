package cn.cc.mytest.java8.learn0403Time;

import java.time.*;
import java.util.*;

public class DateAPILegacySupport {

	public static void main(String[] args) {
		
		//Date to Instant
		Instant timestamp = new Date().toInstant();
		//Now we can convert Instant to LocalDateTime or other similar classes
		LocalDateTime date = LocalDateTime.ofInstant(timestamp, 
				ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
		System.out.println("Date = " + date);
		
		//Calendar to Instant
		Instant time = Calendar.getInstance().toInstant();
		System.out.println(time);
		//TimeZone to ZoneId
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		System.out.println(defaultZone);
		
		//ZoneDateTime from specific Calendar
		ZonedDateTime gregoriantCalendarDateTime = new GregorianCalendar().toZonedDateTime();
		System.out.println(gregoriantCalendarDateTime);
		
		//Date API to Legacy classes
		Date dt = Date.from(Instant.now());
		System.out.println(dt);
		
		TimeZone tz = TimeZone.getTimeZone(defaultZone);
		System.out.println(tz);
		
		GregorianCalendar gc = GregorianCalendar.from(gregoriantCalendarDateTime);
		System.out.println(gc);
		

	}

}
