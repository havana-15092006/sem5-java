import java.util.Scanner;

interface Sports {
    void sportsInfo();
}

interface Academics {
    void academicInfo();
}

class Student implements Sports, Academics {

    String name;
    String sport;
    double mark;

    Student(String name, String sport, double mark) {
        this.name = name;
        this.sport = sport;
        this.mark = mark;
    }

    public void sportsInfo() {
        System.out.println("Sport = " + sport);
    }

    public void academicInfo() {
        System.out.println("Mark = " + mark);
    }

    void display() {
        System.out.println("Name = " + name);
        sportsInfo();
        academicInfo();
    }
}

class MultipleInterfaceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter sport: ");
        String sport = sc.nextLine();

        System.out.print("Enter mark: ");
        double mark = sc.nextDouble();

        Student s = new Student(name, sport, mark);

        s.display();
    }
}