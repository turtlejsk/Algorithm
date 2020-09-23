package test;

import java.sql.Date;

public class PeriodConverter {

	public static String convert(String date) {
		String result = null;
		String ymd = date.substring(0, 10);
		String hr = date.substring(11, 19);
		StringBuilder a = new StringBuilder();
		a.append(ymd);
		a.append(" ");
		a.append(hr);
		result=a.toString();
		return result;
	}


}
