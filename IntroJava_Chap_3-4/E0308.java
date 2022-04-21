import java.util.Scanner;

public class E0308 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter three integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();

    
    if (n1 > n2) {
        int swap = n1;
        n1 = n2;
        n2 = swap;
    }

    if ((n3 < n2 ) && (n3 > n1)) {
        int swap = n3;
        n3 = n2;
        n2 = swap;
    }

    if (n3 < n1) {
        int swap = n3;
        n3 = n2;
        n2 = swap;

        swap = n1;
        n1 = n2;
        n2 = swap;
    }

    System.out.println(n1 + " " + n2 + " " + n3);

    input.close();
    }
}
