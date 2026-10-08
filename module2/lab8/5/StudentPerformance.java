import java.awt.*;
import java.awt.event.*;

public class StudentPerformance extends Frame implements ActionListener {

    TextField name, regNo, mark1, mark2, mark3;
    Button calculate, clear;
    TextArea result;

    StudentPerformance() {

        setTitle("Student Performance Management");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));

        // Student Details Panel
        Panel details = new Panel(new GridLayout(2, 2, 10, 10));

        details.add(new Label("Student Name:"));
        name = new TextField();
        details.add(name);

        details.add(new Label("Register No:"));
        regNo = new TextField();
        details.add(regNo);

        add(details, BorderLayout.NORTH);

        // Marks Panel
        Panel marks = new Panel(new GridLayout(3, 2, 10, 10));

        marks.add(new Label("Mark 1:"));
        mark1 = new TextField();
        marks.add(mark1);

        marks.add(new Label("Mark 2:"));
        mark2 = new TextField();
        marks.add(mark2);

        marks.add(new Label("Mark 3:"));
        mark3 = new TextField();
        marks.add(mark3);

        add(marks, BorderLayout.CENTER);

        // Bottom Panel
        Panel bottom = new Panel(new FlowLayout());

        calculate = new Button("Calculate");
        clear = new Button("Clear");

        bottom.add(calculate);
        bottom.add(clear);

        add(bottom, BorderLayout.SOUTH);

        // Result
        result = new TextArea();
        result.setEditable(false);
        add(result, BorderLayout.EAST);

        calculate.addActionListener(this);
        clear.addActionListener(this);

        // Window Closing using Adapter
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            try {

                double m1 = Double.parseDouble(mark1.getText());
                double m2 = Double.parseDouble(mark2.getText());
                double m3 = Double.parseDouble(mark3.getText());

                double total = m1 + m2 + m3;
                double average = total / 3;

                result.setText(
                    "Student Performance\n\n" +
                    "Name: " + name.getText() + "\n" +
                    "Register No: " + regNo.getText() + "\n\n" +
                    "Total: " + total + "\n" +
                    "Average: " + average
                );

            } catch (NumberFormatException ex) {

                result.setText("Please enter valid marks.");
            }

        } else if (e.getSource() == clear) {

            name.setText("");
            regNo.setText("");
            mark1.setText("");
            mark2.setText("");
            mark3.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}
