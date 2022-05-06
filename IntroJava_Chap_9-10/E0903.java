/* (Use the Date class) Write a program that creates a Date object, sets its elapsed
time to 10000, 100000, 1000000, 10000000, 100000000, 1000000000,
10000000000, and 100000000000, and displays the date and time using the
toString() method, respectively.
*/
import java.util.Date;
public class E0903 {
    public static void main(String[] args) {
        Date date = new Date(10000);
        System.out.println(date.toString());
        for (int i = 0; i < 7; i++) {
            date.setTime(date.getTime()*10);
            System.out.println(date.toString());
        }
    }
}
