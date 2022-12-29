package model;

import java.awt.* ;
import java.util.ArrayList;

import javax.swing.event.*;
import javax.swing.JPanel;

public class DrawingAppModel extends JPanel {

   
	/**
	 * 
	 */
	private Color currentColor= Color.WHITE;
	private static final long serialVersionUID = 1L;
	private final Polygon hexagon = new Polygon();
    private final BasicStroke bs = new BasicStroke(1);
    private final Dimension dimension = getHexagon(0, 0).getBounds().getSize();;
    private final int rows=10, columns=10, side=40;
    private boolean modified = false ;
	
   // getters et setters
   
    private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
    
    public final void setCurrentColor(Color currentColor) {
    	   if (this.currentColor != currentColor) {
    	      this.currentColor = currentColor;
    	      modified = true ;
    	      stateChanged() ;
    	   }
    	}
    
    public void stateChanged() {
		   ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }
		}
   
    
	public void addObserver(ChangeListener listener) {
		listeners.add(listener) ;
	}
	
    
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setColor(Color.black);
       g2d.setStroke(bs);
       for (int row = 0; row < rows; row += 2) {
           for (int column = 0; column < columns; column++) {
               getHexagon(column * dimension.width,
                       (int) (row * side * 1.5));
               
               g2d.draw(hexagon);
           }
       }
       for (int row = 1; row < rows; row += 2) {
           for (int column = 0; column < columns; column++) {
               getHexagon(column * dimension.width + dimension.width / 2,
                       (int) (row * side * 1.5 + 0.5));
               
               g2d.draw(hexagon);
               
           }
       }
   }
   public Polygon getHexagon(final int x, final int y) {
       hexagon.reset();
       int h = side / 2;
       int w = (int) (side * (Math.sqrt(3) / 2));
       hexagon.addPoint(x, y + h);
       hexagon.addPoint(x + w, y);
       hexagon.addPoint(x + 2 * w, y + h);
       hexagon.addPoint(x + 2 * w, y + (int) (1.5 * side));
       hexagon.addPoint(x + w, y + 2 * side);
       hexagon.addPoint(x, y + (int) (1.5 * side));
       return hexagon;
   }
   
}
