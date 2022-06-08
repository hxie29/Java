package c02_Elementary;

import java.util.Scanner;
public class E0207 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of minutes: ");
        int minutes = input.nextInt();
        int day = minutes / 60 / 24;
        int remainDay = day % 365;
        int year = day / 365;
        System.out.println(minutes + " minutes is approximately " + year + " years and " + remainDay + " days.");
        input.close();
    }
}
