package c10_ObjectOrientedThinking;

public class Time {
    //data fields
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

    public Time(long hour, long minute, long second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Methods
    public long getHours() {
        return hour;
    }

    public long getMinutes() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public void setTime(long elapseTime) {
        long totalMilliseconds = (elapseTime >= 0) ? elapseTime : System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        second = totalSeconds % 60;
        long totalMinute = totalSeconds / 60;
        minute = totalMinute % 60;
        long totalHours = totalMinute / 60;
        hour = totalHours % 24;
    }
}
