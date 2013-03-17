import java.awt.*;
import javax.swing.*;

public class Background extends JPanel{
	
	    private Image image;

	    Background(Image image) {
	        this.image = image;
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image,0,0,getWidth(),getHeight(),this);
	    }
	
}