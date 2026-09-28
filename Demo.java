import java.util.Scanner;

interface Printable {
    void print();
}

class Student implements Printable {

    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void print() {
        System.out.println("Student Name = " + name);
        System.out.println("Roll No = " + rollNo);
    }
}

class Teacher implements Printable {

    String name;
    String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void print() {
        System.out.println("Teacher Name = " + name);
        System.out.println("Subject = " + subject);
    }
}

class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter teacher name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter teacher subject: ");
        String subject = sc.nextLine();

        Student s = new Student(studentName, rollNo);
        Teacher t = new Teacher(teacherName, subject);

        System.out.println("\nStudent Details:");
        s.print();

        System.out.println("\nTeacher Details:");
        t.print();
    }
}