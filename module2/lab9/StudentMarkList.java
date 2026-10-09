
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarkList extends JFrame implements ActionListener {

    JTextField name, regno, m1, m2, m3;
    JTextArea result;
    JButton calculate, clear, exit;

    StudentMarkList() {
        setTitle("Student Mark List");
        setSize(450, 450);
        setLayout(new BorderLayout(5, 5));

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));

        form.add(new JLabel("Student Name:"));
        name = new JTextField();
        form.add(name);

        form.add(new JLabel("Register Number:"));
        regno = new JTextField();
        form.add(regno);

        form.add(new JLabel("Mark 1:"));
        m1 = new JTextField();
        form.add(m1);

        form.add(new JLabel("Mark 2:"));
        m2 = new JTextField();
        form.add(m2);

        form.add(new JLabel("Mark 3:"));
        m3 = new JTextField();
        form.add(m3);

        JPanel buttons = new JPanel();
        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        buttons.add(calculate);
        buttons.add(clear);
        buttons.add(exit);

        result = new JTextArea();
        result.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(result), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        calculate.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            try {
                double a = Double.parseDouble(m1.getText());
                double b = Double.parseDouble(m2.getText());
                double c = Double.parseDouble(m3.getText());

                if (a < 0 || a > 100 || b < 0 || b > 100 ||
                    c < 0 || c > 100) {
                    JOptionPane.showMessageDialog(this,
                        "Marks must be between 0 and 100!");
                    return;
                }

                double total = a + b + c;
                double avg = total / 3;
                String grade;

                if (avg >= 90) grade = "A+";
                else if (avg >= 80) grade = "A";
                else if (avg >= 70) grade = "B";
                else if (avg >= 60) grade = "C";
                else if (avg >= 50) grade = "D";
                else grade = "F";

                result.setText(
                    "Name: " + name.getText() +
                    "\nRegister No: " + regno.getText() +
                    "\nTotal: " + total +
                    "\nAverage: " + String.format("%.2f", avg) +
                    "\nGrade: " + grade
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Enter valid marks!");
            }

        } else if (e.getSource() == clear) {
            name.setText("");
            regno.setText("");
            m1.setText("");
            m2.setText("");
            m3.setText("");
            result.setText("");

        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new StudentMarkList();
    }
}
