import java.util.Scanner;

public class E0311 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the month: ");
        int month = input.nextInt();
        System.out.println("Please enter days after year: ");
        int year = input.nextInt();
        
        switch (month) {
            case 1: System.out.print("January"); break;
            case 2: System.out.print("Feb"); break;
            case 3: System.out.print("March"); break;
            case 4: System.out.print("April"); break;
            case 5: System.out.print("May"); break;
            case 6: System.out.print("June"); break;
            case 7: System.out.print("July"); break;
            case 8: System.out.print("August"); break;
            case 9: System.out.print("Sep"); break;
            case 10: System.out.print("Oct"); break;
            case 11: System.out.print("November"); break;
            case 12: System.out.print("December"); break;
        }

        System.out.print(" " + year + " has");
        if ( (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12) ) {
                System.out.println("31 days");
            }
        else if (month == 2) {
            if (year % 4 == 0) {
                    System.out.println("29 days");
                }
                else 
                System.out.println("28 days");
            }
        else {
            System.out.println("30 days");
        }  

    input.close();
    }
}

