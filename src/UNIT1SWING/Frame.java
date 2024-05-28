package UNIT1SWING;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-05-28
 **/
public class Frame {

    public static void main(String[] args) {
        JFrame frame  = new JFrame();
        frame.setTitle("Welcome to UNIT1")  ;
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200,200);
        frame.setVisible(true);
    }
}
