/*(Generic PriorityQueue using Comparator) Revise MyPriorityQueue
in Listing 24.8, using a generic parameter for comparing objects. Define a new
constructor with a Comparator as its argument as follows:
PriorityQueue(Comparator<? super E> comparator)*/
package c24_ImpleListStackQueue;

public class E2406 {
    public static void main(String[] args) {
        Patient p1 = new Patient("John", 2);
        Patient p2 = new Patient("Jim", 2);
        Patient p3 = new Patient("Tim", 5);
        Patient p4 = new Patient("Cindy", 7);

        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(new PatientComparator());
        patientQueue.enqueue(p1);
        patientQueue.enqueue(p2);
        patientQueue.enqueue(p3);
        patientQueue.enqueue(p4);

        while (patientQueue.getSize() > 0) {
            System.out.println(patientQueue.dequeue());
        }
    }
}
