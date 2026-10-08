import java.awt.*;
import java.awt.event.*;

public class MouseKeyboardDemo extends Frame {

    Label position;

    MouseKeyboardDemo() {

        setTitle("Mouse and Keyboard Events");
        setSize(500, 400);
        setLayout(new FlowLayout());

        position = new Label("Move mouse or click inside the window");
        add(position);

        // Mouse Adapter
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                position.setText(
                    "Mouse clicked at X = " +
                    e.getX() + ", Y = " + e.getY()
                );
            }
        });

        // Mouse Motion Adapter
        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {
                position.setText(
                    "Mouse position: X = " +
                    e.getX() + ", Y = " + e.getY()
                );
            }
        });

        // Keyboard Adapter
        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                position.setText(
                    "Key pressed: " + e.getKeyChar()
                );
            }
        });

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseKeyboardDemo();
    }
}
