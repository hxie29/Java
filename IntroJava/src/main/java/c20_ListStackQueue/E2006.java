/*(Use iterators on ArrayList) Write a test program that stores 10 million integers
in ascending order (i.e., 1,2, . . ., 10m) in an ArrayList, displays the execution
time taken to traverse the list, and searches for the 10 millionth element using
the get(index) vs using the iterator method.*/
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Iterator;

public class E2006 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 99999999; i++) {
            list.add(i+1);
        }
        Iterator<Integer> iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        long endTime;
        double n;

        for (Integer integer : list) n = integer;
        endTime = System.currentTimeMillis();
        System.out.println("Use get method takes " + (endTime - startTime) + " milliseconds");
        //447 milliseconds

        startTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            n = iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Use iterator method takes " + (endTime - startTime) + " milliseconds");
        //149 milliseconds

    }
}
