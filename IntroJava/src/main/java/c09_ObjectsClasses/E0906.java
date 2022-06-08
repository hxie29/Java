package c09_ObjectsClasses;
/* (Stopwatch) Design a class named StopWatch. The class contains:
■■ Private data fields startTime and endTime with getter methods.
■■ A no-arg constructor that initializes startTime with the current time.
■■ A method named start() that resets the startTime to the current time.
■■ A method named stop() that sets the endTime to the current time.
■■ A method named getElapsedTime() that returns the elapsed time for the
stopwatch in milliseconds.
Draw the UML diagram for the class then implement the class. Write a test program
that measures the execution time of sorting 100,000 numbers using selection sort.
*/

public class E0906 {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        int n = 1;
        for (int i = 0; i < Math.pow(10, 3); i++){
            n++;
        }
        System.out.println(n);
        watch.stop();
        System.out.println(watch.getElapsedTime());
    }
}
