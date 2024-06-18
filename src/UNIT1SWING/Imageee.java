package UNIT1SWING;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-16
 **/
public class Imageee extends JFrame {

    public Imageee(){
        add(new ImageComponent());
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new Imageee();
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            frame.setSize(screenWidth / 2, screenHeight / 2);
            frame.setLocationByPlatform(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("Image Test");
        });
    }
}
