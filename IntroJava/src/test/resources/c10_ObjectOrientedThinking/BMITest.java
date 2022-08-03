package c10_ObjectOrientedThinking;

import org.junit.jupiter.api.Test;

import static c10_ObjectOrientedThinking.BMI.INCHES_PER_FEET;
import static c10_ObjectOrientedThinking.BMI.METERS_PER_INCH;
import static org.junit.jupiter.api.Assertions.*;

class BMITest {

    @Test
    void getBMI() {
        double inch = 3, feet = 6, weight = 53;
        var case1 = new BMI("me", 29,weight,feet,inch);
        double height = METERS_PER_INCH * (inch + feet * INCHES_PER_FEET);
        double bmi =  Math.round(weight / height / height * 100) / 100.0;;
        assertEquals(bmi, case1.getBMI());
    }

    @Test
    void getStatus() {
        double inch = 3, feet = 6, weight = 53;
        var case1 = new BMI("me", 29,weight,feet,inch);
        assertEquals("Underweight", case1.getStatus());
    }
}