package c13_AbstractClassesInterfaces;

class Course implements Cloneable {
    //Data fields
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    // Constructor
    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        int index = findStudent(student, students);
        if (index == -1) System.out.println("Student not registered in the course:");
        else {
            String[] temp = new String[students.length];
            if (index == 0) {
                System.arraycopy(students, 1, temp, 0, students.length - 1);
            } else {
                System.arraycopy(students, 0, temp, 0, index);
                System.arraycopy(students, index + 1, temp, index, students.length - 1 - index);
            }
            students = temp;
            numberOfStudents--;
        }
    }

    public void clear() {
        students = new String[100];
        numberOfStudents = 0;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseNmae() {
        return courseName;
    }

    public String[] getStudents() {
        return students;
    }

    private int findStudent(String student, String[] students) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(student)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        Course c = new Course(courseName);
        for (String student : students) {
            if (student != null)
                c.addStudent(student);
        }
        return c;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + "\nStudents' number: " + numberOfStudents;
    }


}
