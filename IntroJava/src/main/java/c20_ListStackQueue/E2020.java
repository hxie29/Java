/*(Nonrecursive Tower of Hanoi) Implement the moveDisks method in Listing 18.8
using a stack instead of using recursion.*/
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class E2020 {
    private static int moves;
    private static int numberOfDisks;
    private static final ArrayList<Stack<Integer>> towers = new ArrayList<>(3);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of disks:");
        numberOfDisks = input.nextInt();
        towers.add(new Stack<>());
        towers.add(new Stack<>());
        towers.add(new Stack<>());

        for (int i = numberOfDisks; i > 0; i--) {
            towers.get(0).push(i);
        }
        Stack<Integer> towerB = towers.get(1);
        while (towerB.size() != numberOfDisks) {
            if (numberOfDisks % 2 == 0) {
                moveDisk(0,2);
                moveDisk(0,1);
                moveDisk(1,2);
            }
            else {
                moveDisk(0,1);
                moveDisk(0,2);
                moveDisk(2,1);
            }
        }

        System.out.println(moves + " moves are made.");
    }

    private static void moveDisk(int a, int b) {
        if (towers.get(1).size() == numberOfDisks)
            return;

        Stack<Integer> towerA = towers.get(a);
        Stack<Integer> towerB = towers.get(b);
        moves++;
        int disk;
        if (towerA.isEmpty() && towerB.isEmpty()) {}
        else if (towerA.isEmpty()) {
            towerA.push(towerB.pop());
            disk = towerA.peek();
            displayMove(b,a, disk);
        }
        else if (towerB.isEmpty()) {
            towerB.push(towerA.pop());
            disk = towerB.peek();
            displayMove(a,b,disk);
        }
        else {
            if (towerA.peek() < towerB.peek()) {
                towerB.push(towerA.pop());
                disk = towerB.peek();
                displayMove(a,b,disk);
            }
            else {
                towerA.push(towerB.pop());
                disk = towerA.peek();
                displayMove(b,a, disk);
            }
        }
    }
    private static void displayMove(int a, int b, int disk) {
        String from = (a == 0) ? "Tower A" : (a == 1) ? "Tower B" : "Tower C";
        String to = (b == 0) ? "Tower A" : (b == 1) ? "Tower B" : "Tower C";
        System.out.println("Move disk " + disk + " from " + from + " to " + to);
    }
}
