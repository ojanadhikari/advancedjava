package UNIT1SWING;

import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-16
 **/
public class Font2 extends MyFrame{
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        String message = "Hello World";
        Font font1 = new Font("Yrsa", Font.BOLD, 20);
        Font font2 = new Font("Timmana", Font.PLAIN, 30);
        Font font3 = new Font("Roboto", Font.ITALIC, 40);
        g2d.setFont(font3);
        g2d.drawString(message, 100, 100);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            Font2 f = new Font2();
        });
    }
}
