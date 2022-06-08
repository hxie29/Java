package c09_ObjectsClasses;

public class StopWatch {
    //Data fields
    private long startTime;
    private long endTime;

    // Constructor
    StopWatch() {
        startTime = System.currentTimeMillis();
    }

    //Methods
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }
}
