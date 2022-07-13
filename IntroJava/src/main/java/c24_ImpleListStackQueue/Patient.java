package c24_ImpleListStackQueue;

public class Patient implements Comparable<Patient> {
    private final String name;
    private int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + "(priority: " + priority + ")";
    }

    @Override
    public int compareTo(Patient o) {
        return this.priority - o.priority;
    }
}
