/*(ComplexMatrix) Use the Complex class introduced in Programming Exercise 13.17
to develop the ComplexMatrix class for performing matrix opera tions involving
complex numbers. The ComplexMatrix class should extend the GenericMatrix
class and implement the add, multiple, and zero methods. You need to modify
GenericMatrix and replace every occurrence of Number by Object because Complex
is not a subtype of Number. Write a test program that creates the following
two matrices and displays the result of addition and multiplication of the matrices by
invoking the printResult*/
package c19_Generics;

import c13_AbstractClassesInterfaces.Complex;

public class E1911 {
    public static void main(String[]args) {
        Complex[][] m1 = new Complex[3][3];
        Complex[][] m2 = new Complex[3][3];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] = new Complex(i+1, j+2);
                m2[i][j] = new Complex(i+2, j+3);
            }
        }

        ComplexMatrix complexMatrix = new ComplexMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix2.printResult(m1, m2, complexMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");
        GenericMatrix2.printResult(m1, m2, complexMatrix.multiplyMatrix(m1, m2),'*');
    }
}
