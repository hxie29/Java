/* (Game: bean machine) The bean machine, also known as a quincunx or the Galton
box, is a device for statistics experiments named after English scientist Sir Francis Galton. 
It consists of an upright board with evenly spaced nails (or pegs) in a triangular form.

Balls are dropped from the opening of the board. Every time a ball hits a nail, it
has a 50% chance of falling to the left or to the right. The piles of balls are accumulated
in the slots at the bottom of the board.

Write a program that simulates the bean machine. Your program should prompt the user to enter 
the number of the balls and the number of the slots in the machine. Simulate the falling of each 
ball by printing its path. For example, the path for the ball in Figure 7.13b is LLRRLLR and 
the path for the ball in Figure 7.13c is RLRRLRR. Display the final buildup of the balls in 
the slots in a histogram. Here is a sample run of the program:

(Hint: Create an array named slots. Each element in slots stores the number
of balls in a slot. Each ball falls into a slot via a path. The number of Rs in a path
is the position of the slot where the ball falls. For example, for the path LRLRLRR,
the ball falls into slots[4], and for the path RRLLLLL, the ball falls into slots[2].)
*/

import java.util.Scanner;
public class E0737 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of slots: ");
        int[] slots = new int[input.nextInt()];
        int[] slotsPoints = new int[slots.length];
        givePoints(slotsPoints);
        //printInt(slotsPoints);
        System.out.println("Enter the number of balls: ");
        int numberOfBalls = input.nextInt();

        for (int i = 1; i <= numberOfBalls; i++) {
            int ballPoint = oneBallPoint(slots);
            int index = linearSearch(slotsPoints, ballPoint);
            slots[index]++;
        }
        printInt(slots);
        
        input.close();  
    }
     
    // assign the points required for each 
    public static void givePoints(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = -list.length + 1 + 2 * i;
        }
    }

    // for each lever down, the points are either -1 (left) or 1 (right)
    public static int getDirection() {
        int[] direction = {-1, 1};
        char[] leftRight = {'L', 'R'};
        int index = (int)(Math.random() + 0.5);
        System.out.print(leftRight[index]);
        return direction[index];
    }

    // calculate points for one ball
    public static int oneBallPoint(int[] list) {
        int point = 0;
        for (int i = 1; i <= list.length -1; i++) {
            point += getDirection();
        }
        System.out.println();
        return point;
    }

    // print int array
    public static void printInt(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print("Slot " +  (i + 1) + " has " + list[i] + " balls.\n");
        }
        System.out.println();
    }

    // linear search function returning matching key's index number in the array
    public static int linearSearch(int[] list, int point){
        for (int i = 0; i < list.length; i++) {
            if (point == list[i]) return i;
        }
        return -1;
    }

}
        