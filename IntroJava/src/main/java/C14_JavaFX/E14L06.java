package C14_JavaFX;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class E14L06{
    public static void main(String[] args) {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        System.out.println("d1 is " + d1.getValue() + " d2 is " + d2.getValue());
        d1.bind(d2);
        d2.set(70);
        System.out.println("d1 is " + d1.getValue() + " d2 is " + d2.getValue());
    }
}
