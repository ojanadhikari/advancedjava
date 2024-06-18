package UNIT1SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-03
 **/
public class Ellipse extends MyFrame{
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse2D = new Ellipse2D.Double(200, 200, 250, 250);
        g2d.fill(ellipse2D);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            Ellipse ellipse = new Ellipse();
            ellipse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ellipse.setTitle("Circle");
            ellipse.setVisible(true);
        });
    }
}
