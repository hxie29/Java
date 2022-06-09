package c15_EventsAnimations;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class E15L10 {
    public static void main(String[] args ){
        DoubleProperty balance1 = new SimpleDoubleProperty();
        DoubleProperty balance2 = new SimpleDoubleProperty();

        balance1.addListener(new InvalidationListener() {
           public void invalidated(Observable ov) {
               System.out.println("The new value is " + balance1.doubleValue());
           } 
        });

        balance1.set(4.5);

        balance2.addListener(ov ->
                System.out.println("The new value is " + balance2.doubleValue())
         );

         balance2.set(10);
    }
}