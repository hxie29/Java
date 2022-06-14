/*(ComplexMatrix) Use the Complex class introduced in Programming Exercise 13.17
to develop the ComplexMatrix class for performing matrix operations involving
complex numbers. The ComplexMatrix class should extend the GenericMatrix
class and implement the add, multiple, and zero methods. You need to modify
GenericMatrix and replace every occurrence of Number by Object because Complex
is not a subtype of Number. Write a test program that creates the following
two matrices and displays the result of addition and multiplication of the matrices by
invoking the printResul19.*/
package c19_Generics;

import c13_AbstractClassesInterfaces.Complex;

public class ComplexMatrix extends GenericMatrix2<Complex>{

    @Override
    protected Complex add(Complex o1, Complex o2) {
        return o1.add(o2);
    }

    @Override
    protected Complex multiply(Complex o1, Complex o2) {
        return o1.multiply(o2);
    }

    @Override
    public Complex zero() {
        return new Complex(0,0);
    }

}
