import java.util.Scanner;

public class E03L04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the weight in kg: ");
        double weight = input.nextDouble();
        System.out.println("Please enter the height in meter: ");
        double height = input.nextDouble();
        double bmi = weight / height / height;
        System.out.println("Your BMI is " + (int)(bmi * 100) / 100.0);
    
        if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi < 25.0)
            System.out.println("Normal");
        else if (bmi < 30.0)
            System.out.println("Overweight");
        else 
            System.out.println("Obese");
            input.close();
    }
}
