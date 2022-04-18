import java.util.Scanner;

public class E02L05 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter an integer for seconds;");
    int second = input.nextInt();
    int remainSecond = second%60;
    int minute = second/60;
    int hour = minute/60;
    int remainMinute = minute%60;
    System.out.println("time is " + hour + " hours " + remainMinute + " minutes and " + remainSecond + " seconds");
    input.close();
    }
}
