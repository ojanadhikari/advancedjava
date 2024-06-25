package UNIT1SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-03
 **/
public class Line extends MyFrame {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
//        Line2D line = new Line2D.Double(50, 50, 200, 200);
        g2d.drawLine(50,50,200,200);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            Line line = new Line();
            line.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            line.setTitle("Line");
            line.setVisible(true);
        });
    }
}
