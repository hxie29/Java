package c32_Muiltithreading;

import java.util.ArrayList;
import java.util.Random;

public class demo_Locks {
    public static void main() {

    }

    static class SomeClass {

        private final Random random = new Random();
        private final ArrayList<Integer> list1 = new ArrayList<>();
        private final ArrayList<Integer> list2 = new ArrayList<>();
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void method1() {
            synchronized (lock1) {
                for (int i = 0; i < 1000; i++) {
                    list1.add(random.nextInt());
                }
            }
        }

        public void method2() {
            synchronized (lock2) {
                for (int i = 0; i < 1000; i++) {
                    list2.add(random.nextInt());
                }
            }
        }
    }
}
