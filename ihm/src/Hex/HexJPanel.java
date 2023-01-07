package Hex;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.JPanel;

import iu.DrawingApp;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class HexJPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingApp drawingApp ;

	
	private final BasicStroke bs1 = new BasicStroke(1);
	private final BasicStroke bs3 = new BasicStroke(3);
	private final Polygon hexagon = new Polygon();
	private final Dimension dimension = getHexagon().getBounds().getSize();
	HexJPanelMouseListener	HexJPanelMouseListener = new HexJPanelMouseListener(drawingApp);
	private Point mousePosition;
	private final Point focusedHexagonLocation = new Point();
	private boolean bl;
	private int x;
	private int y;
	
	public HexJPanel(DrawingApp drawingApp,int x,int y){
		super();
		this.drawingApp = drawingApp;
		this.x = x;
	    this.y = y;
		
		HexJPanelMouseListener = new HexJPanelMouseListener(drawingApp);
		
		addMouseListener(HexJPanelMouseListener);
	}
	
	
	 public void paintComponent(Graphics g) {
	   super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setColor(Color.black);
       g2d.setStroke(bs1);
       if (y %2 ==0) {
               getHexagon();
               if (mousePosition !=null && hexagon.contains(mousePosition)){
                   focusedHexagonLocation.x = y * dimension.width;
                   focusedHexagonLocation.y = (int) (x * 40 * 1.5);
              
                   
               }
               g2d.draw(hexagon);
             //  setBackground(Color.WHITE) ;
      			
      	
          
       }else {
       
               getHexagon();
               if (mousePosition!= null && hexagon.contains(mousePosition)){
                   focusedHexagonLocation.x = y * dimension.width
                           + dimension.width / 2;
                   focusedHexagonLocation.y =(int) (x * 40 * 1.5 + 0.5);
                   bl =true;
               }
               g2d.draw(hexagon);
              // setBackground(Color.WHITE) ;
      			
      	      
               
         
       }
       if (bl == true) {
           g2d.setColor(Color.red);
           g2d.setStroke(bs3);
           Polygon focusedHexagon = getHexagon();
           g2d.draw(focusedHexagon);
           //setBackground(Color.WHITE) ;
  			
  	 
           
       }
     /*  if (bl == true && HexJPanelMouseListener.bl2 ) {
    	   String options[]={ "Wall Hex", "Arrival Hex", "Departure Hex", "Empty Hex"};
   		String option = JOptionsPane.showOptionDialog(null," What's the type of that Hex ","Select the type you want",0,4,null,options,options[0]);
   		if (option == "Wall Hex") {hex.setLabel("W");}else if (option == "Arrival Hex") {
   			hex.setLabel("A");
   		}else if (option == "Departure Hex") {
   			hex.setLabel("D");
   		}else{
   			hex.setLabel("E");
   		}
       }*/
   }
   public Polygon getHexagon() {
       hexagon.reset();
       int h = 40 / 2;
       int w = (int) (40 * (Math.sqrt(3) / 2));
       hexagon.addPoint(x, y + h);
       hexagon.addPoint(x + w, y);
       hexagon.addPoint(x + 2 * w, y + h);
       hexagon.addPoint(x + 2 * w, y + (int) (1.5 * 40));
       hexagon.addPoint(x + w, y + 2 * 40);
       hexagon.addPoint(x, y + (int) (1.5 * 40));
       return hexagon;
   }
	   
	
	public void notifyForUpdate() {
		repaint();
		HexJPanelMouseListener.bl2 =false;
	}
}
