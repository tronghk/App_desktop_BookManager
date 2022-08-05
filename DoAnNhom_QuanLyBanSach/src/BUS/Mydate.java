package BUS;

import java.time.LocalDate;

public class Mydate {
	static String monthStr[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Nov","Dec"};
	static int monthInt[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	public static String Date(String date) {
		String month1 = "", day1 = "";
		String temp[] = date.split(" ");
		try {
			int month = 0;
			temp[1] = temp[1].substring(0, temp[1].length()-1);
			int day = Integer.parseInt(temp[1]);
			for(int i=0;i<monthStr.length;i++) {
				if(monthStr[i].compareTo(temp[0]) == 0) {
					month = monthInt[i];
					break;
				}
			}
			if(month >12 || month == 0)
				return null;
			if(day > 31 || day <1)
				return null;
			
			int year = Integer.parseInt(temp[2]);
			if(year < 2000)
				return null;
			if(month <10)
				month1 = "0"+month;
			else month1 = ""+month;
			if(day <10)
				day1 = "0"+day; 
			else
				day1 = "" + day;
			return year+"-"+month1+"-"+day1;
		}catch(Exception ex) {
			return null;
		}
	}
	public static String DatePhatTrien(String date) {
		String month1 = "", day1 = "";
		String temp[] = date.split(" ");
		try {
			int month = 0;
			temp[1] = temp[1].substring(0, temp[1].length()-1);
			int day = Integer.parseInt(temp[1]);
			for(int i=0;i<monthStr.length;i++) {
				if(monthStr[i].compareTo(temp[0]) == 0) {
					month = monthInt[i];
					break;
				}
			}
			if(month >12 || month == 0)
				return null;
			if(day > 31 || day <1)
				return null;
			
			int year = Integer.parseInt(temp[2]);
			if(year < 1800)
				return null;
			if(month <10)
				month1 = "0"+month;
			else month1 = ""+month;
			if(day <10)
				day1 = "0"+day; 
			else
				day1 = "" + day;
			return year+"-"+month1+"-"+day1;
		}catch(Exception ex) {
			return null;
		}
	}
}
