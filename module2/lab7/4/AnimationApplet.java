import java.applet.Applet;
import java.awt.*;

public class AnimationApplet extends Applet
        implements Runnable {

    int x = 0;
    Thread thread;
    boolean running = false;

    public void init() {

        setBackground(Color.WHITE);
    }

    public void start() {

        running = true;

        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {

        while (running) {

            x = x + 5;

            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLUE);
        g.fillOval(x, 100, 50, 50);
    }

    public void stop() {

        running = false;
        thread = null;
    }
}