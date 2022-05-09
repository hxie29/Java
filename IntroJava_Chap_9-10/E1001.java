/*
(The Time class) Design a class named Time. The class contains:
■■ The data fields hour, minute, and second that represent a time.
■■ A no-arg constructor that creates a Time object for the current time. (The
values of the data fields will represent the current time.)
■■ A constructor that constructs a Time object with a specified elapsed time
since midnight, January 1, 1970, in milliseconds. (The values of the data fields will represent this time.)
■■ A constructor that constructs a Time object with the specified hour, minute, and second.
■■ Three getter methods for the data fields hour, minute, and second, respectively.
■■ A method named setTime(long elapseTime) that sets a new time for the
object using the elapsed time. For example, if the elapsed time is 555550000
milliseconds, the hour is 10, the minute is 19, and the second is 10.

Draw the UML diagram for the class then implement the class. Write a
test program that creates three Time objects (using new Time(), new
Time(555550000), and new Time(5, 23, 55)) and displays their hour,
minute, and second in the format hour:minute:second.
(Hint: The first two constructors will extract the hour, minute, and second
from the elapsed time. For the no-arg constructor, the current time can be
obtained using System.currentTimeMillis(), as shown in Listing 2.7,
Show CurrentTime.java. Assume the time is in GMT.)
*/
public class E1001 {
    public static void main(String[] args) {
        Time timeObject = new Time();
        System.out.println(timeObject.getHours() + " : " + timeObject.getMinutes() + " : " + timeObject.getSecond());
        Time time2 = new Time(5, 23, 55);
        System.out.println(time2.getHours() + " : " + time2.getMinutes() + " : " + time2.getSecond());
    }
}

class Time{
    //data fiels
    private long hour;
    private long minute;
    private long second;

    //Constructor
    public Time() {
        setTime(-1);
    }

    public Time(long totalMilliseconds) {
        setTime(totalMilliseconds);
    }

    public Time(long hour, long minute, long second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Methods
    public long getHours(){
        return hour;
    }
    public long getMinutes(){
        return minute;
    }
    public long getSecond(){
        return second;
    }

    public void setTime(long elapseTime){
        long totalMilliseconds = (elapseTime >= 0) ? elapseTime : System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        second = totalSeconds % 60;
        long totalMinute = totalSeconds / 60;
        minute = totalMinute % 60;
        long totalHours = totalMinute / 60;
        hour = totalHours % 24;
    }
}
