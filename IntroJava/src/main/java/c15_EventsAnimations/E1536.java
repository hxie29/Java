/* 
(Simulation: self-avoiding random walk) Write a simulation program to show
that the chance of getting dead-end paths increases as the grid size increases.
Your program simulates lattices with size from 10 to 80 with increments of 5.
For each lattice size, simulate a self-avoiding random walk 10,000 times
and display the probability of the dead-end paths, as shown in the following
sample output:
For a lattice of size 10, the probability of dead-end paths is 10.6%
For a lattice of size 15, the probability of dead-end paths is 14.0%
...
For a lattice of size 80, the probability of dead-end paths is 99.5%
}
*/

package c15_EventsAnimations;

public class E1536 {
    public static void main(String[] args ){
        int lattice = 10;
        while (lattice <= 80) {
            RandomWalkPane randomWalk = new RandomWalkPane(lattice, lattice);
            int deadEnd = 0;
            int count = 0;
            while (count < 10000) {
                randomWalk.reset();
                deadEnd += randomWalk.walk();
                count++;
            }
            //System.out.println(deadEnd);
            double chance = deadEnd * 1.0 / count;
            System.out.println("For a lattice of size " + lattice + ", the probablity of dead-end paths is " + (int)(chance * 1000) / 10.0 + "%");
            lattice += 5;
        }
    }
}
