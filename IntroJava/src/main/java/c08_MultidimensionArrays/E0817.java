package c08_MultidimensionArrays;/* If a bank’s total assets are under a certain limit, the bank is unsafe. The money it
borrowed cannot be returned to the lender, and the lender cannot count the loan in
its total assets. Consequently, the lender may also be unsafe, if its total assets are
under the limit. 

Write a program to find all the unsafe banks. Your program reads the input as follows. 
It first reads two integers n and limit, where n indicates the number of banks and limit is 
the minimum total assets for keeping a bank safe. It then reads n lines that describe the 
information for n banks with IDs from 0 to n−1. The first number in the line is the bank’s balance, 
the second number indicates the number of banks that borrowed money from the bank, and the rest are pairs
of two numbers. Each pair describes a borrower. The first number in the pair is
the borrower’s ID and the second is the amount borrowed. */

import java.util.Scanner;
public class E0817 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of banks:");
        int numberOfBanks = input.nextInt();
        System.out.println("Enter the bottom limit of total assets to keep the bank safe: ");
        double safeLimit = input.nextDouble();
        
        double[] bankBalance = new double[numberOfBanks];
        double[][] borrower = new double[numberOfBanks][numberOfBanks];
        double[] bankAssets = new double[numberOfBanks];
        int[] unsafeBanks = new int[numberOfBanks];
        java.util.Arrays.fill(unsafeBanks, -1);

        // reads balances and lending
        for (int i = 0; i < numberOfBanks; i++) {
            System.out.println("Enter the balance for bank " + i);
            bankBalance[i] = input.nextDouble();
            System.out.println("Enter the number of borrowers for bank " + i);
            int borrowerNumber = input.nextInt();
            for (int k = 0; k < borrowerNumber; k++) {
                System.out.println("Enter the borrower's index and the borrowing amount");
                int index = input.nextInt();
                borrower[i][index] = input.nextDouble();
            }
        }
        input.close();

        // check defaults untill no more new banks are added to unsafe list
        int[] count = {0};
        int initialCount = -1;
        while (initialCount != count[0]) {
            initialCount = count[0];
            calcBanlance(bankAssets, bankBalance, borrower);
            checkDefault(bankAssets, unsafeBanks, borrower, count, safeLimit);
        }

        printUnsafeBanks(unsafeBanks);
    }

    //Calculate bank balances
    public static void calcBanlance(double[]bankAssets, double[]bankBalance, double[][]borrower) {
        for (int i = 0; i < bankAssets.length; i++) {
            bankAssets[i] = bankBalance[i];
            for (int j = 0; j < bankAssets.length; j++) {
                bankAssets[i] += borrower[i][j];
            }
        }
    }
    // Check Defaults   
    public static void checkDefault(double[]bankAssets, int[]unsafeBanks, double[][]borrower, int[] count, double safeLimit) {
        for (int i = 0; i < bankAssets.length; i++) {
            if (bankAssets[i] < safeLimit && !matchUnsafe(i, unsafeBanks)) {
                count[0]++;
                unsafeBanks[count[0] - 1] = i;
                for (int k = 0; k < bankAssets.length; k++) {
                    borrower[k][i] = 0;
                    // System.out.println("Borrow from " + k + " to " + i + " is set to zero.");
                } 
            }
        } 
    }
    

    // print out unsafe banks
    public static void printUnsafeBanks(int[]unsafeBanks) {
        for (int unsafeBank : unsafeBanks) {
            if (unsafeBank != -1) System.out.println("Unsafe banks are " + unsafeBank);
        }
    }
   
    // linear search if the unsafe banks is recorded
    public static boolean matchUnsafe(int n, int[]unsafeBanks) {
        for (int unsafeBank : unsafeBanks) {
            if (n == unsafeBank) return true;
        }
        return false;
    }
}
