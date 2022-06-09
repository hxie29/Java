package c13_AbstractClassesInterfaces;/*
(Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform
a deep copy of the list field.
*/

public class E1308 {
    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push(2);
        m.push(4.2);
        m.push(9);

        try {
            MyStack m2 = (MyStack) m.clone();
            System.out.println(m == m2);
            System.out.println(m);
            System.out.println(m.getList() == m2.getList());
        } 
        catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

