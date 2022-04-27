import java.util.Scanner;

public class E0621 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();
        System.out.println(stringToNumber(str));
        input.close();
    }

    public static String stringToNumber(String str) {
        String numberString = "";
        int length = str.length();
        for (int i = 0; i< length; i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-') {
                numberString += str.charAt(i);
            }
            else if (Character.isLetter(str.charAt(i))) {
                numberString += getNumber(Character.toUpperCase(str.charAt(i)));
            }
            else {
                numberString = "Invalid input. Please enter only digits or ltters with -.";
            }
        }
        return numberString;
    }  

    public static int getNumber(char capitaLetter) {
        if ("ABC".contains(capitaLetter + "")) {
            return 2;
        }
        else if ("DEF".contains(capitaLetter + "")) {
            return 3;
        }
        else if ("GHI".contains(capitaLetter + "")) {
            return 4;
        }
        else if ("JKL".contains(capitaLetter + "")) {
            return 5;
        }
        else if ("MNO".contains(capitaLetter + "")) {
            return 6;
        }
        else if ("PQRS".contains(capitaLetter+ "")) {
            return 7;
        }
        else if ("TUV".contains(capitaLetter+ "")) {
            return 8;
        }
        else {
            return 9;
        }
    }

}
