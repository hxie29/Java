/*(Natural numbers and their squares) Knowing that (x + 1)2 = x2 + 2x + 1,
and that multiplication is more time consuming than addition, write an efficient
program that displays the first ten natural numbers and their squares. Knowing
that (x + 1)3 = x3 + 3x2 + 3x + 1, the same process can be followed to display
the cubes of these numbers.
Here is a sample run:
0^2 = 0
1^2 = 1
2^2 = 4
...
8^2 = 64
9^2 = 81
10^2 = 100 */
package c22_EfficientAlgorithms;

public class E2201 {
    public static void main(String[] args) {
        int n = 0;
        int square = 0;
        System.out.println(n + "^2 = " + square);

        for (int i = 1; i < 11; i++) {
            n = i;
            square += n + n -1;
            System.out.println(n + "^2 = " + square);
        }

        n = 0;
        square = 0;
        int cube = 0;
        System.out.println(n + "^3 = " + cube);

        for (int i = 1; i < 11; i++) {
            cube += square + square + square + n + n +n + 1;
            n = i;
            square += n + n -1;
            System.out.println(n + "^3 = " + cube);
        }
    }
}
