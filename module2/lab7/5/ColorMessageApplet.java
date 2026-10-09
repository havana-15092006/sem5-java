import java.applet.Applet;
import java.awt.*;

public class ColorMessageApplet extends Applet {

    String message;
    Color backgroundColor;
    Color foregroundColor;

    public void init() {

        message = getParameter("message");

        String bg = getParameter("background");
        String fg = getParameter("foreground");

        if (bg.equalsIgnoreCase("red"))
            backgroundColor = Color.RED;
        else if (bg.equalsIgnoreCase("green"))
            backgroundColor = Color.GREEN;
        else if (bg.equalsIgnoreCase("blue"))
            backgroundColor = Color.BLUE;
        else if (bg.equalsIgnoreCase("yellow"))
            backgroundColor = Color.YELLOW;
        else
            backgroundColor = Color.WHITE;

        if (fg.equalsIgnoreCase("red"))
            foregroundColor = Color.RED;
        else if (fg.equalsIgnoreCase("green"))
            foregroundColor = Color.GREEN;
        else if (fg.equalsIgnoreCase("blue"))
            foregroundColor = Color.BLUE;
        else if (fg.equalsIgnoreCase("black"))
            foregroundColor = Color.BLACK;
        else
            foregroundColor = Color.BLACK;

        setBackground(backgroundColor);
        setForeground(foregroundColor);
    }

    public void paint(Graphics g) {

        g.setFont(new Font("Arial", Font.BOLD, 20));

        g.drawString(message, 100, 120);
    }
}