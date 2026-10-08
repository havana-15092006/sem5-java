import java.applet.Applet;
import java.awt.*;

public class StudentApplet extends Applet {

    String name;
    String regNo;
    String course;
    String semester;

    public void init() {

        name = getParameter("name");
        regNo = getParameter("regno");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    public void paint(Graphics g) {

        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString("Student Information", 100, 50);

        g.setFont(new Font("Arial", Font.PLAIN, 16));

        g.drawString("Name       : " + name, 70, 100);
        g.drawString("Register No: " + regNo, 70, 140);
        g.drawString("Course     : " + course, 70, 180);
        g.drawString("Semester   : " + semester, 70, 220);
    }
}
