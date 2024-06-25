package UNIT1SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-05-28
 **/
public class Shapes extends JFrame {

    public Shapes() {
        super("Rectangles Drawing Demo");
        getContentPane().setBackground(Color.WHITE);
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void drawShapes(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(200, 200, 200, 200); //code to draw line
        g2d.drawLine(50, 50, 200, 180); //code to draw ellipse
        g2d.draw(new Ellipse2D.Double(400, 400, 250, 250));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawShapes(g);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(()-> {
                new Shapes().setVisible(true);
        });
    }

}
