package UNIT1SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-16
 **/
public class Coloou extends MyFrame{

    //BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW
    @Override
    public void paint(Graphics g) {

        Color color = new Color(83, 49, 49);
        Graphics2D g2d = (Graphics2D) g;
//        g2d.setPaint(Color.RED);
        g2d.setPaint(color);
        g2d.drawString("Hello World!", 50, 50);

        Rectangle2D rect = new Rectangle2D.Double(100, 100, 200, 200);
        g2d.fill(rect);
    }

    public static void main(String[] args) {


        EventQueue.invokeLater(()->{
            Coloou frame = new Coloou();
        });
    }
}
