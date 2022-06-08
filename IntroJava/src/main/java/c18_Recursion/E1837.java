/*(Hilbert curve) The Hilbert curve, first described by German mathematician
David Hilbert in 1891, is a space-filling curve that visits every point in a square
grid with a size of 2 * 2, 4 * 4, 8 * 8, 16 * 16, or any other power of 2.
Write a program that displays a Hilbert curve for the specified order, as shown
in Figure 18.19.*/
package com.example.recursion;

public class E1837 {
    // sample client for testing
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 60.0;
        double step = Math.sqrt(3)/2;
        Turtle turtle = new Turtle(x0, y0, a0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.show();
    }
}
