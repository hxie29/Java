import java.util.Scanner;

public class E0423 {
    public static void main(String [] args)    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter employee's name: ");
        String name = input.nextLine();
        System.out.println("the number of hours worked in a week: ");
        double hours = input.nextDouble();
        System.out.println("Enter hourly pay rate: ");
        double rate = input.nextDouble();
        System.out.println("Enter Federal tax withholding rate: ");
        double fedRate = input.nextDouble();
        System.out.println("Enter state tax withholding rate: ");
        double stateRate = input.nextDouble();

        double gross = rate * hours;
        double fedHold = gross * fedRate;
        double statHold = gross * stateRate;
        double deduction = fedHold + statHold;
        double netPay = gross - deduction;

        System.out.println("Employee Name: " + name);
        System.out.println("Hours worked: " + hours);
        System.out.println("Pay rate: $" + rate);
        System.out.println("Gross pay: $" + (int)(gross * 100) / 100.0);
        System.out.println("Deductions: ");
        System.out.println("    Federal Withhodling (" + (int)(fedRate * 1000)/10.0 +"%): $" + (int)(fedHold*10)/10.0);
        System.out.println("    State Withhodling (" + (int)(stateRate * 1000)/10.0 +"%): $" + (int)(statHold*10)/10.0);
        System.out.println("    Total Deduction: $" + (int)(deduction * 10)/10.0);
        System.out.println("Net pay: $" + (int)(netPay *100)/100.0);

        input.close();
    }
} 
