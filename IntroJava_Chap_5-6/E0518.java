import java.util.Scanner;

public class E0518 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        
        // Pattern A
        System.out.println("Enter an integer:");
        int number = input.nextInt();
        for (int count =1; count <= number; count++) {
            for (int printnumber = 1; printnumber <= count; printnumber++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern B
        System.out.println("Enter an integer:");
        number = input.nextInt();
        for (int count =number; count > 0; count--) {
            for (int printnumber = 1; printnumber <= count; printnumber++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // Pattern C
        System.out.println("Enter an integer:");
        number = input.nextInt();
        for (int count =1; count <= number; count++) {
            int star = count;
            int empty = number - count;
            for (int printempty = 1; printempty <= empty; printempty++) {
                System.out.print("  ");
            }
            while (star > 0){
                System.out.print("* ");
                star--;
            }
            System.out.println();
        }
        
        // Pattern D
        System.out.println("Enter an integer:");
        number = input.nextInt();
        for (int count = number; count > 0; count--) {
            int star = count;
            int empty = number - count;
            for (int printempty = 1; printempty <= empty; printempty++) {
                System.out.print("  ");
            }
            while (star > 0){
                System.out.print("* ");
                star--;
            }
            System.out.println();
        }
        input.close();
    }    
}