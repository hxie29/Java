package c24_ImpleListStackQueue;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        if (o1.getPriority() - o2.getPriority() == 0)
            return o2.getName().compareTo(o1.getName());
        return o1.getPriority() - o2.getPriority();
    }
}
