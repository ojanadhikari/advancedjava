package UNIT1SWING;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-03
 **/
public class MyComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        g.drawString("This is my component", 100, 100);
    }
}
