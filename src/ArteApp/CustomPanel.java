package ArteApp;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CustomPanel extends JPanel{    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    Image image = new ImageIcon(Login.class.getResource("/botones/fondo.jpg")).getImage();
 
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        super.paint(g);
    }
}
