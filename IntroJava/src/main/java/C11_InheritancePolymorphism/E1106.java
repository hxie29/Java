package C11_InheritancePolymorphism;

import java.util.ArrayList;
import java.util.Date;

public class E1106{
    public static void main(String[] args){
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Circle(5));
        list.add(new Date());
        list.add(new AccountNew(101, 5000));
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        System.out.println(list.get(2).toString());

    }
}
