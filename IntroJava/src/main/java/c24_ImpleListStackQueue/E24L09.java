package c24_ImpleListStackQueue;

public class E24L09 {
    public static void main(String[] args) {
        Patient p1 = new Patient("John", 2);
        Patient p2 = new Patient("Jim", 1);
        Patient p3 = new Patient("Tim", 5);
        Patient p4 = new Patient("Cindy", 7);

        MyPriorityQueue<Patient> patientQueue = new MyPriorityQueue<>();
        patientQueue.enqueue(p1);
        patientQueue.enqueue(p2);
        patientQueue.enqueue(p3);
        patientQueue.enqueue(p4);

        while (patientQueue.getSize() > 0) {
            System.out.println(patientQueue.dequeue());
        }
    }

}
