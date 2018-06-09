import java.util.*;

public class MonthDayComparator implements Comparator<MyDate>{
	
	@Override public int compare(MyDate d1, MyDate d2) {
		Integer this_month = d1.getMonth();
		Integer other_month = d2.getMonth();
		int month_comp = this_month.compareTo(other_month);
		if (month_comp != 0) {
			return month_comp;
		}
		
		Integer this_day = d1.getDay();
		Integer other_day = d2.getDay();
		Integer day_comp = this_day.compareTo(other_day);
		if (day_comp != 0) {
			return day_comp;
		}
		
		Integer this_year = d1.getYear();
		Integer other_year = d2.getYear();
		int year_comp = this_year.compareTo(other_year);
		return year_comp;
	}
}
