package c13_AbstractClassesInterfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
An instance of java.util.Date represents a specific instant in time with millisecond
precision. java.util.Calendar is an abstract base class for extracting detailed calendar
information, such as the year, month, date, hour, minute, and second. Subclasses of
Calendar can implement specific calendar systems, such as the Gregorian calendar, the
lunar calendar, and the Jewish calendar. Currently, java.util.GregorianCalendar
for the Gregorian calendar is supported in Java, as shown in Figure 13.3. The add method
is abstract in the Calendar class because its implementation is dependent on a concrete
calendar system.
You can use new GregorianCalendar() to construct a default GregorianCalendar
with the current time and new GregorianCalendar(year, month, date) to construct a
GregorianCalendar with the specified year, month, and date. The month parameter is
0-based—that is, 0 is for January.
The get(int field) method defined in the Calendar class is useful for extracting the
date and time information from a Calendar object. The fields are defined as constants, as
shown in Table 13.1.
Listing 13.6 gives an example that displays the date and time information for the current
time.
*/
public class E13L06 {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.println("Current time is " + new Date());
        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        System.out.println("Hour: " + calendar.get(Calendar.HOUR));
        System.out.println("Hour of the day: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Second: " + calendar.get(Calendar.SECOND));

        Calendar calendar2 = new GregorianCalendar(1997, Calendar.DECEMBER, 25);
        String[] day = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        System.out.println("December 25, 1997 is a " + day[calendar2.get(Calendar.DAY_OF_WEEK) - 1]);
    }
}
