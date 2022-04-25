import java.util.Scanner;

public class E0528 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the year");
        int year = input.nextInt();
        boolean leap = (year % 4 == 0);
        
        System.out.println("Enter the first day of the year (0~6 for Sunday to Saturday):");
        int janDay = input.nextInt();
        int count = 0;
        int monthDay = 0;

        //print out line for each month
        for (int k = 1; k <= 12; k++) {

            // print out month 
            switch (k) {
                case 1: System.out.print("January"); break;
                case 2: System.out.print("Feburary"); break;
                case 3: System.out.print("March"); break;
                case 4: System.out.print("April"); break;
                case 5: System.out.print("May"); break;
                case 6: System.out.print("June"); break;
                case 7: System.out.print("July"); break;
                case 8: System.out.print("August"); break;
                case 9: System.out.print("September"); break;
                case 10: System.out.print("October"); break;
                case 11: System.out.print("November"); break;
                case 12: System.out.print("December"); break;
            }

            System.out.print(" 1, " + year + " is ");

            // calculate day of following month
            if (k == 1) {
                monthDay = janDay;
            }

            // calculate March after !leap year
            else if ((k == 3) && leap) {
                monthDay += 29;
            }
            else if ((k == 3) && !leap) {
                monthDay +=28;
            }

            // the month after a 30-day month
            else if ((k == 5) || (k == 7) || (k == 10) || (k == 12)) {
                monthDay += 30;
            }

            else {
                monthDay += 31;
            }

            // print out
            switch (monthDay % 7) {
                case 0: System.out.println("Sunday"); break;
                case 1: System.out.println("Monday"); break;
                case 2: System.out.println("Tuesday"); break;
                case 3: System.out.println("Wednesday"); break;
                case 4: System.out.println("Thursday"); break;
                case 5: System.out.println("Friday"); break;
                case 6: System.out.println("Saturday"); break;
            }
        }
        input.close();
    }    
}
