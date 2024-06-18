package UNIT1SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-03
 **/
public class Rect extends MyFrame {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(200, 200, 200, 200);
        g2d.fill(rect);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            Rect rect = new Rect();
            rect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rect.setTitle("Rectangle");
            rect.setVisible(true);
        });
    }

}
