import java.util.Scanner;

public class E0517 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int number = input.nextInt();
        int figure = number;
        
        while (figure > 0){
            while (figure > 0) {
                System.out.print(figure + " ");
                figure--;
            }
            figure+=2;
            while (figure <= number){
                System.out.print(figure + " ");
                figure ++;
            }
            /* System.out.print("print the next line or stop (1 or 0)\n");
            int stop = input.nextInt();
            if (stop == 0) {
                break;
            }
            else */
            number--;
            figure = number;
            System.out.println();
        }
        input.close();
    }    
}