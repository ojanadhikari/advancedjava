package UNIT1SWING;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-03
 **/
public class MyFrame extends JFrame {
    public MyFrame(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Mu Custom Frame");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
            MyComponent myComponent = new MyComponent();
            frame.add(myComponent);
        });
    }
}
