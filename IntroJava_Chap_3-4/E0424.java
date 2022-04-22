import java.util.Scanner;

public class E0424 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first country: ");
        String country1 = input.nextLine();
        System.out.println("Please enter the second country: ");
        String country2 = input.nextLine();
        System.out.println("Please enter the third country: ");
        String country3 = input.nextLine();

        if (country1.compareToIgnoreCase(country2) < 0) {
            String temp = country1;
            country1 = country2;
            country2 = temp;
        }
        
        if (country2.compareToIgnoreCase(country3) > 0) {
            System.out.println("The three countries in descending order are " + country1 + " ," + country2 + " ," +country3);
        }
        else if (country1.compareToIgnoreCase(country3) < 0) {
            System.out.println("The three countries in descending order are " + country3 + " ," + country2 + " ," +country1);
        }
        else {
            System.out.println("The three countries in descending order are " + country1 + " ," + country3 + " ," +country2);
        }

        input.close();
    }
}
