import java.awt.*;
import java.awt.event.*;

public class ColorSelection extends Frame implements ActionListener {

    Panel panel;
    Button red, green, blue, yellow;

    ColorSelection() {

        setTitle("Color Selection");
        setSize(500, 300);
        setLayout(new BorderLayout());

        panel = new Panel();
        panel.setLayout(new FlowLayout());

        red = new Button("Red");
        green = new Button("Green");
        blue = new Button("Blue");
        yellow = new Button("Yellow");

        panel.add(red);
        panel.add(green);
        panel.add(blue);
        panel.add(yellow);

        add(panel, BorderLayout.CENTER);

        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        yellow.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == red)
            panel.setBackground(Color.RED);

        else if (e.getSource() == green)
            panel.setBackground(Color.GREEN);

        else if (e.getSource() == blue)
            panel.setBackground(Color.BLUE);

        else if (e.getSource() == yellow)
            panel.setBackground(Color.YELLOW);
    }

    public static void main(String[] args) {
        new ColorSelection();
    }
}
