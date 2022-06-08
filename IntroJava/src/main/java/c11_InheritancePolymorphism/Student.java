package c11_InheritancePolymorphism;

class Student extends Person {
    private int status;
    private final int FRESHMAN = 1;
    private final int SOPHOMORE = 2;
    private final int JUNIOR = 3;
    private final int SENIOR = 4;

    public Student() {
    }

    public Student(String name, String address, String phoneNumber, String email) {
        super(name, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Student";
    }
}
