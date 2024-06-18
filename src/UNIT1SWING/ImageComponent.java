package UNIT1SWING;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-06-16
 **/
public class ImageComponent extends JComponent {

    private Image image;

    public ImageComponent() {
        Image image1 = new ImageIcon("200w.gif").getImage();
         this.image = image1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int height = 200;
        int width = 300;
        g.drawImage(image,0,0,width,height,null);
        for(int i=0;i*width<=getWidth();i++) {
            for(int j=0;j*height<=getHeight();j++) {
                if(i+j>0){
                    g.copyArea(0,0,width,height,i*width,j*height);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300,200);
    }
}
