import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    TextField num1, num2, result;
    Button add, sub, mul, div;

    SimpleCalculator() {

        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new Label("First Number:"));
        num1 = new TextField();
        add(num1);

        add(new Label("Second Number:"));
        num2 = new TextField();
        add(num2);

        add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        add(result);

        add = new Button("Add");
        sub = new Button("Subtract");
        mul = new Button("Multiply");
        div = new Button("Divide");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double ans = 0;

            if (e.getSource() == add)
                ans = a + b;

            else if (e.getSource() == sub)
                ans = a - b;

            else if (e.getSource() == mul)
                ans = a * b;

            else if (e.getSource() == div) {

                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }

                ans = a / b;
            }

            result.setText(String.valueOf(ans));

        } catch (NumberFormatException ex) {

            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}