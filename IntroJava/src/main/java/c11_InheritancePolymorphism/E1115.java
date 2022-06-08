package c11_InheritancePolymorphism;/*
(Area of a convex polygon) A polygon is convex if it contains any line segments
that connects two points of the polygon. Write a program that prompts the user
to enter the number of points in a convex polygon, enter the points clockwise,
then displays the area of the polygon. For the formula for computing the area of
a polygon, see http://www.mathwords.com/a/area_convex_polygon.htm.

Here is a sample run of the program:
Enter the number of points: 7
Enter the coordinates of the points:
-12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -13.5
The total area is 292.575
*/

import java.util.ArrayList;
import java.util.Scanner;
public class E1115 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points");
        int n = input.nextInt();

        //Create arraylist of n points for the polygon
        System.out.println("Enter the points");
        ArrayList<MyPoint> points = new ArrayList<>();
        for (int i = 0; i < n; i++){
            double x = input.nextDouble();
            double y = input.nextDouble();
            //Enter clockwise, calculate area needs counter clockwise order
            points.add(0, new MyPoint(x,y));
        }

        //Caculate area
        System.out.println("The total area is "+ getArea(points));
        input.close();
    }

    public static double getArea(ArrayList<MyPoint> points){
        double area = 0.5 * ((points.get(0).getY() * points.get(points.size() - 1).getX())
                            - (points.get(0).getX() * points.get(points.size() - 1).getY()));
        for (int i = 0; i < points.size() - 1; i++){
            area += 0.5 * ((points.get(i).getX() * points.get(i+1).getY()) - (points.get(i).getY() * points.get(i+1).getX()));
        }
        return area;
    }

}
