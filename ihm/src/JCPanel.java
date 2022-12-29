import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JCPanel extends JPanel implements MouseListener {
	int x;
	int y=0;
    private static final long serialVersionUID = 1L;
	public JCPanel() {
        super();
       
        
        setPreferredSize(new Dimension(2,2));
        addMouseListener(this);
    }

    Color c = Color.red;
    public void paint(Graphics g) {
	     
  	   g.clearRect(0,0,2000,2000);
         g.setColor(c);
         int i =0;

        	 int[] HexagonXs = {150+100*i,200+100*i,200+100*i,150+100*i,100+100*i,100+100*i};
             int[] HexagonYs = {50+this.y*250,100+this.y*250,200+this.y*250,250+this.y*250,200+this.y*250,100+this.y*250};
             g.fillPolygon(HexagonXs, HexagonYs,6);
        
         
    
  }
    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        double d = Math.sqrt((x-300)*(x-300) + (y-300)*(y-300));
        if (d <= 100) {
        	if (c == Color.red) {
        		c = Color.cyan;
                repaint();
        	}else {
        		c = Color.red;
                repaint();
        	}
            
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
