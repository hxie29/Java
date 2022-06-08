package c07_SingleDimensionArrays;/* (Game: locker puzzle) A school has 100 lockers and 100 students. All lockers are
closed on the first day of school. As the students enter, the first student, denoted
as S1, opens every locker. Then the second student, S2, begins with the second
locker, denoted as L2, and closes every other locker. Student S3 begins with the
third locker and changes every third locker (closes it if it was open and opens it if
it was closed). Student S4 begins with locker L4 and changes every fourth locker.
Student S5 starts with L5 and changes every fifth locker, and so on, until student S100 changes L100.

After all the students have passed through the building and changed the lockers,
which lockers are open? Write a program to find your answer and display all open
locker numbers separated by exactly one space.

(Hint: Use an array of 100 Boolean elements, each of which indicates whether a
locker is open (true) or closed (false). Initially, all lockers are closed.) */

public class E0723 {
    public static void main(String[] args) {

        // initiate 101 closed lockers, set all to false. 0 remain untouched afterwards.
        boolean[] locker = new boolean[101];
        java.util.Arrays.fill(locker, false);

        // processing all the lockers
        for (int i = 1; i < locker.length; i++) {
            for (int j = i; j < locker.length; j+=i) {
                locker[j] = !locker[j];
            }
        }

        System.out.println("The open lockers are: ");
        // display open lockers
        int count = 0;
        for (int i = 1; i < locker.length; i++) {
            if (locker[i]) {
                count++;
                System.out.print((count % 10 == 0) ? i + "\n" : i + " ");
            }   
        }
    }
}
