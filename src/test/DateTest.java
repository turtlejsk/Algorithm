package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.xmlbeans.XmlCursor.TokenType;

public class DateTest {
	public static void main(String[] args) {
		
		String input = "2018-02-03T08:00:00.000Z";
		//toDate("2018-02-14T08:00:00.000Z");
		//System.out.println(compare("2018-02-14T08:00:00.000Z"));
		System.out.println(toString4Schd(input));
	}
	
	 public static String toString4Schd (String input){
	        String result = "Error";
	        String ymd=  input.substring(0, 10);
	        String time = input.substring(11, 23);
	        String[] token = ymd.split("-");
	        int month= Integer.parseInt(token[1]);
	        int day =  Integer.parseInt(token[2]);
	        StringBuffer sb = new StringBuffer();
	   
	        sb.append(month);
	        sb.append("월 ");
	        sb.append(day);
	        sb.append("일 ");
	        
	        String[] token2 = time.split(":");
	        int hr= Integer.parseInt(token2[0]);
	        int min= Integer.parseInt(token2[1]);
	        
	        sb.append(hr);
	        sb.append("시 ");
	        if(min!=0) {
		        sb.append(min);
		        sb.append("분");
	        }else {
	        	sb.append("00분");
	        }
	    
	        
	        
	        result = sb.toString();
	        return result;
	    }
	
	 public static Date toDate(String input){
		 	input.substring(11, 15);
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        Date date= null;
	        Date result = null;
	        try {
	            date = sdf.parse(input);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
//
//	        Calendar c = Calendar.getInstance();
//	        c.setTime(date);
//	        c.getTime().getMonth();
//
//	        date = c.getTime();
//	        date.toString();
//	        String aft_st_date = sdf.format(date);
//	        System.out.println("Time " +input.substring(11, 15));
//	        System.out.println("Date " +input.substring(0, 9));
	        return date;
	    }
	 
	 public static int compare(String input){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
	        Date date= null;
	        try {
	            date = sdf.parse(input);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        System.out.println(date);
	        Calendar c = Calendar.getInstance();
	        String now = "2018-02-15T19:00:00.000Z";
	        Date dateNow=null;
	        try {
	            dateNow = sdf.parse(now);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        if(date.after(dateNow)){
	            return 0;
	        }else if(date.before(dateNow)){
	            return 2;
	        }else{
	        return 1;
	        }
	    }
	 
	 
	 public static String setLocale(String input){
	        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	        String result = formatter.format(toDate(input));
	        System.out.println(result);
	        
	        formatter.setTimeZone(TimeZone.getTimeZone("KST"));
	        result = formatter.format(toDate(input));
	        System.out.println(result);
	        return result;
	    }
}
