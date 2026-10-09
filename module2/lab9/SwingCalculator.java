
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator extends JFrame implements ActionListener {

    JTextField n1, n2, result;
    JButton add, sub, mul, div;

    SwingCalculator() {
        setTitle("Simple Calculator");
        setSize(350, 300);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("First Number:"));
        n1 = new JTextField();
        add(n1);

        add(new JLabel("Second Number:"));
        n2 = new JTextField();
        add(n2);

        add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());
            double ans;

            if (e.getSource() == add)
                ans = a + b;
            else if (e.getSource() == sub)
                ans = a - b;
            else if (e.getSource() == mul)
                ans = a * b;
            else {
                if (b == 0) {
                    JOptionPane.showMessageDialog(this,
                        "Cannot divide by zero!");
                    return;
                }
                ans = a / b;
            }

            result.setText(String.valueOf(ans));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}
