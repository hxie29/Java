public class E11L06 {
    public static void main(String[] args){
        m(new GraduateStudent());
        m(new Student());
        m(new Person());
        m(new Object());
    }

    public static void m(Object o){
        System.out.println(o.toString());
    }
}

class GraduateStudent extends Student{
    @Override 
    public String toString(){
        return "Graduate student";
    }
}

class Student extends Person{
    @Override
    public String toString(){
        return "Student";
    }
}

class Person{
    @Override
    public String toString(){
        return "Person";
    }
}
