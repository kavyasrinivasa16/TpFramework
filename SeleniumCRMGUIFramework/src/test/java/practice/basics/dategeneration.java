package practice.basics;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dategeneration {

	public static void main(String[] args) {
		
		java.util.Date dateObj = new java.util.Date();
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(dateObj);
		System.out.println(actdate);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String daterequires = sim.format(cal.getTime());
		System.out.println(daterequires);
		}

}
