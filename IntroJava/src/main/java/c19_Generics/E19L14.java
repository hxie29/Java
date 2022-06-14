package c19_Generics;

import c13_AbstractClassesInterfaces.Rational;

public class E19L14 {
    public static void main(String[] args) {
        Rational[][] m1 = new Rational[3][3];
        Rational[][] m2 = new Rational[3][3];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = new Rational(i + 1, j +5);
                m2[i][j] = new Rational(i + 1, j + 6);
            }
        }

        RationalMatrix rationalMatrix = new RationalMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, rationalMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
    }
}
