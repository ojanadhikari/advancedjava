package UNIT1SWING;

import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-03
 **/
public class Fontss {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }
}
