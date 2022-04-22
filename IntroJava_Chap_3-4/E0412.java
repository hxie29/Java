import java.util.Scanner;

public class E0412 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a hex digit: ");
        char number = Character.toUpperCase((input.nextLine()).charAt(0));
        
        int d = 0;

        if (number >= 'A' && number <='F') {
             d = number - 'A' + 10;
        }
        else {
            d = number -'0';
        }

        System.out.print("The binary value is ");

        switch(d) {
			case 0: System.out.println(0000); break; 
			case 1: System.out.println(0001); break; 
			case 2: System.out.println(0010); break; 
			case 3: System.out.println(0011); break; 
			case 4: System.out.println(0100); break; 
			case 5: System.out.println(0101); break; 
			case 6: System.out.println(0110); break; 
			case 7: System.out.println(0111); break; 
			case 8: System.out.println(1000); break; 
			case 9: System.out.println(1001); break; 
			case 10: System.out.println(1010); break; 
			case 11: System.out.println(1011); break; 
			case 12: System.out.println(1100); break; 
			case 13: System.out.println(1101); break; 
			case 14: System.out.println(1110); break; 
			case 15: System.out.println(1111); break; 
        }

        input.close();
    }
}
