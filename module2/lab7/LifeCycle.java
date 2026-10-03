import java.applet.Applet;
import java.awt.Graphics;

public class LifeCycle extends Applet {

    public void init() {
        System.out.println("init() called");
    }

    public void start() {
        System.out.println("start() called");
    }

    public void paint(Graphics g) {
        g.drawString("Applet Life Cycle", 50, 50);
        System.out.println("paint() called");
    }

    public void stop() {
        System.out.println("stop() called");
    }

    public void destroy() {
        System.out.println("destroy() called");
    }
}
