/*(public static void exp(double x, int n) {
        double sum = 1.0;
        double xExp = 1.0;
        int nExp = 1;
        for (int i = 1; i <= n; i++) {
            xExp *= x;
            nExp *= i;
            sum += xExp / nExp;
        }
        System.out.println("exp(" + x + ", " + n + ") = " + sum);
    }) Write a method public static double
exp(double x, int n) that computes exp(x, n), which is an approximation
of the exponential of x to the order n.
exp(x, n) = x0/0! + x1/1! + x2/2! + c + xn/n!
Analyze the time complexity of your method. Here is a sample run:
exp(1.0, 0) = 1.0
exp(1.0, 2) = 2.5
exp(1.0, 4) = 2.708333333333333
exp(1.0, 6) = 2.7180555555555554
exp(1.0, 8) = 2.71827876984127
exp(1.0, 10) = 2.7182818011463845
*/
package c22_EfficientAlgorithms;

public class E2204 {
    public static void main(String[] args) {
        exp(1.0,0);
        exp(1.0,2);
        exp(1.0,4);
        exp(1.0,6);
        exp(1.0,8);
        exp(1.0,10);
    }

    // Complexity is O(n)

    public static void exp(double x, int n) {
        double sum = 1.0;
        double xExp = 1.0;
        int nExp = 1;
        for (int i = 1; i <= n; i++) {
            xExp *= x;
            nExp *= i;
            sum += xExp / nExp;
        }
        System.out.println("exp(" + x + ", " + n + ") = " + sum);
    }

}
