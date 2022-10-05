package com.example.demo.extra.helpdesk;

import java.util.Calendar;

public class HelpDesk {

	public final static int END_OF_BUSINESS_HOUR = 17;

	public boolean willHandleIssue(Issue issue) {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
			return false;
		}
		if (Calendar.FRIDAY == dayOfWeek) {
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			return hour <= END_OF_BUSINESS_HOUR;
		}
		return true;
	}
}
