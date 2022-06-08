package c06_Methods;

import java.util.Scanner;

public class E0618 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = input.nextLine();

        System.out.println(checkPassword(password) ? "Your chosen password is valid." : "Your chosen password is not valid.");
        input.close();
    }
    
    public static boolean checkPassword(String password) {
        return (checkLength(password) && checkCharacter(password) && checkNumberOfDigits(password));
    }

    public static boolean checkLength(String password) {
       return (password.length() >= 10);
    }

    public static boolean checkCharacter(String password) {
        boolean character = true;
        int length = password.length();
        for (int i = 0; i <length; i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                character = false;
                break;
            }
        }
        return character;
    }

    public static boolean checkNumberOfDigits(String password) {
        int sum = 0;
        int length = password.length();
        for (int i = 0; i <length; i++) {
            if (Character.isDigit(password.charAt(i))) {
                sum++;
            }
        }
        return (sum >=3);
    }
       
}
