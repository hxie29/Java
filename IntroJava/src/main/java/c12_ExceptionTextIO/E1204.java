package c12_ExceptionTextIO;

/*
(IllegalArgumentException) Modify the Loan class in Listing 10.2 to
throw IllegalArgumentException if the loan amount, interest rate, or
number of years is less than or equal to zero.
*/
public class E1204{
    public static void main(String[] args) {
        try {
            Loan l = new Loan(-2, 1, -1000);
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Wrong input: " + ex.getMessage());
        }
    }
}

