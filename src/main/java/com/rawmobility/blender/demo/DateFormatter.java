package com.rawmobility.blender.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {
	public static final String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
	public static final String dateTimeZoneFormat = "yyyy-MM-dd'T'HH:mm:ss z";

	public static Date parse(String source) throws ParseException {
		SimpleDateFormat df4 = new SimpleDateFormat(dateFormat);
		try {
			return df4.parse(source.replace(' ', '+'));
		} catch (ParseException e) {
			try {
				SimpleDateFormat dtzf = new SimpleDateFormat(dateTimeZoneFormat);
				return dtzf.parse(source);
			} catch (ParseException e2) {
				SimpleDateFormat dtzf = new SimpleDateFormat(dateTimeFormat);
				return dtzf.parse(source);
			}
		}
	}

	public static String toString(Date source) throws ParseException {
		SimpleDateFormat df4 = new SimpleDateFormat(dateTimeFormat);
		return df4.format(source);
	}

	public static void shiftToSystem(TimeZone sysTz, Date userTime, TimeZone userTz) {
		
		DateFormat df = new SimpleDateFormat(DateFormatter.dateTimeFormat);
	
		df.setTimeZone(userTz);
		String sysDeliverySchedule = df.format(userTime);

		df = new SimpleDateFormat(DateFormatter.dateTimeFormat);
		df.setTimeZone(sysTz);
		
		Date newDate = null;
		try {
			newDate = df.parse(sysDeliverySchedule);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Old: " + newDate);
		System.out.println("New: " + newDate);
	}

}