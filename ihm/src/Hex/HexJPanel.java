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
	
	private Hex hex;
	private final BasicStroke bs1 = new BasicStroke(1);
	private final BasicStroke bs3 = new BasicStroke(3);
	private DrawingApp drawingApp ;
	private final Polygon hexagon = new Polygon();
	private final Dimension dimension = getHexagon(0, 0).getBounds().getSize();
	HexJPanelMouseListener	HexJPanelMouseListener = new HexJPanelMouseListener(drawingApp);
	private boolean bl =false;
	private Point mousePosition;
	private final Point focusedHexagonLocation = new Point();
	
	public HexJPanel(DrawingApp drawingApp,Hex hex){
		HexJPanelMouseListener = new HexJPanelMouseListener(drawingApp);
		this.hex = hex;
		addMouseListener(HexJPanelMouseListener);
	}
	
	public Hex getHex() {
		return hex;
		}
	
	 @Override
	public void paintComponent(Graphics g) {
	   super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setColor(Color.black);
       g2d.setStroke(bs1);
       if (hex.getY() %2 ==0) {
               getHexagon(hex.getY() * dimension.width,
                       (int) (hex.getX() * 40 * 1.5));
               if (mousePosition !=null && hexagon.contains(mousePosition)){
                   focusedHexagonLocation.x = hex.getY() * dimension.width;
                   focusedHexagonLocation.y = (int) (hex.getX() * 40 * 1.5);
                   bl =true;
                   
               }
               g2d.draw(hexagon);
           
       }else {
       
               getHexagon(hex.getY() * dimension.width + dimension.width / 2,
                       (int) (hex.getX() * 40 * 1.5 + 0.5));
               if (mousePosition!= null && hexagon.contains(mousePosition)){
                   focusedHexagonLocation.x = hex.getY() * dimension.width
                           + dimension.width / 2;
                   focusedHexagonLocation.y =(int) (hex.getX() * 40 * 1.5 + 0.5);
                   bl =true;
               }
               g2d.draw(hexagon);
               
         
       }
       if (bl == true) {
           g2d.setColor(Color.red);
           g2d.setStroke(bs3);
           Polygon focusedHexagon = getHexagon(focusedHexagonLocation.x,
                   focusedHexagonLocation.y);
           g2d.draw(focusedHexagon);
           
       }
       if (bl == true && HexJPanelMouseListener.bl2 ) {
    	   String options[]={ "Wall Hex", "Arrival Hex", "Departure Hex", "Empty Hex"};
   		/*String option = JOptionsPane.showOptionDialog(null," What's the type of that Hex ","Select the type you want",0,4,null,options,options[0]);
   		if (option == "Wall Hex") {hex.setLabel("W");}else if (option == "Arrival Hex") {
   			hex.setLabel("A");
   		}else if (option == "Departure Hex") {
   			hex.setLabel("D");
   		}else{
   			hex.setLabel("E");
   		}*/
       }
   }
   public Polygon getHexagon(int x,int y) {
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
