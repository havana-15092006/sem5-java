import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends Frame implements ActionListener {

    TextField name, regNo;
    Choice course;
    Checkbox male, female;
    Button submit, clear;
    TextArea result;

    StudentRegistration() {

        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(new BorderLayout());

        // Form Panel
        Panel form = new Panel(new GridLayout(5, 2, 10, 10));

        form.add(new Label("Name:"));
        name = new TextField();
        form.add(name);

        form.add(new Label("Register No:"));
        regNo = new TextField();
        form.add(regNo);

        form.add(new Label("Course:"));
        course = new Choice();
        course.add("BCA");
        course.add("BSc Computer Science");
        course.add("BTech");
        course.add("MCA");
        form.add(course);

        form.add(new Label("Gender:"));
        Panel genderPanel = new Panel(new FlowLayout());
        male = new Checkbox("Male");
        female = new Checkbox("Female");

        genderPanel.add(male);
        genderPanel.add(female);
        form.add(genderPanel);

        submit = new Button("Submit");
        clear = new Button("Clear");

        form.add(submit);
        form.add(clear);

        add(form, BorderLayout.NORTH);

        // Result Area
        result = new TextArea();
        add(result, BorderLayout.CENTER);

        submit.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            String gender = "";

            if (male.getState())
                gender = "Male";
            else if (female.getState())
                gender = "Female";

            result.setText(
                "Student Details\n\n" +
                "Name: " + name.getText() + "\n" +
                "Register No: " + regNo.getText() + "\n" +
                "Course: " + course.getSelectedItem() + "\n" +
                "Gender: " + gender
            );

        } else if (e.getSource() == clear) {

            name.setText("");
            regNo.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
