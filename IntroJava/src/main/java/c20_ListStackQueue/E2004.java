/*(Implement Comparable) Implement a new class that implements Comparator
of GregorianCalendar class to be able sort the calendar in increasing
order based on day, month, and year, in that order. Write a method to display
the GregorianCalendar instance in “dd-MMM-yyyy” format using
SimpleDateFormat class. Write a test program with 10 GregorianCalendar
instances and display the results after the sort.*/
package c20_ListStackQueue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;


public class E2004 {
    public static void main(String[] args) {
        ArrayList<GregorianCalendar> calendars = new ArrayList<>();
        for (int i = 0; i< 10; i++) {
            calendars.add(new GregorianCalendar(2000, i,i + 10));
        }
        calendars.sort(new CalendarComparator());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        calendars.forEach(e -> System.out.println(sdf.format(e.getTime())));
    }

    static class CalendarComparator implements Comparator<GregorianCalendar> {
        @Override
        public int compare(GregorianCalendar o1, GregorianCalendar o2) {
            if (o1.get(Calendar.DATE) != o2.get(Calendar.DATE)) {
                return o1.get(Calendar.DATE) - o2.get(Calendar.DATE);
            }
            else if (o1.get(Calendar.MONTH) != o2.get(Calendar.MONTH)) {
                return o1.get(Calendar.MONTH) - o2.get(Calendar.MONTH);
            }
            else
                return o1.get(Calendar.YEAR) - o2.get(Calendar.YEAR);
        }
    }
}
