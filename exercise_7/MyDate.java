import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;

public class MyDate implements Comparable<MyDate>{
	
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) throws Exception{
		
		if (day < 1 || day > 31) {
			throw new Exception(String.format("%d is not a valid value of a day (1 - 31).", day));
		}
		
		if (month < 1 || month > 12) {
			throw new Exception(String.format("%d is not a valid value of a month (1 - 12).", month));
		}
		
		if (year > Year.now().getValue()) {
			throw new Exception(String.format("Invalid Date:\nThe entered date lies in the future. Please enter a valid birth date.", year));
		}

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		String str_year = String.valueOf(year);
		String str_month;
		String str_day;
		
		if (month < 10) {
			str_month = "0" + String.valueOf(month);
		} else {
			str_month = String.valueOf(month);
		}
		if (day < 10) {
			str_day = "0" + String.valueOf(day);
		} else {
			str_day = String.valueOf(day);
		}
		return str_year + "-" + str_month + "-" + str_day;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
	@Override
	public int hashCode() {
		return day * 3 + month * 5 + year * 7;
	}

	
	@Override
	public int compareTo(MyDate other_date) {

		Integer this_year = year;
		Integer other_year = other_date.getYear();
		int year_comp = this_year.compareTo(other_year);
		if (year_comp != 0) {
			return year_comp;
		}
		Integer this_month = month;
		Integer other_month = other_date.getMonth();
		int month_comp = this_month.compareTo(other_month);
		if (month_comp != 0) {
			return month_comp;
		}
		Integer this_day = day;
		Integer other_day = other_date.getDay();
		Integer day_comp = this_day.compareTo(other_day);
		return day_comp;
	}
	

}