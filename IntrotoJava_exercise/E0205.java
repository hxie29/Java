import java.util.Scanner;
public class E0205 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the subtotal: ");
        double subtotal = input.nextDouble();
        System.out.println("Please enter the gratuity rate (%), e.g. 12: ");
        double gratuityRate = input.nextDouble();
        double gratuity = subtotal * gratuityRate / 100;
        double total = subtotal + gratuity;
        System.out.println("The gratuity is $" +  (int)(gratuity*100) / 100.0 + " and the total is $" + (int)(total*100) / 100.0);
        input.close();

    }

}
