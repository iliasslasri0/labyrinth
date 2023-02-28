package iu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	 
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;
	
	   public DrawingPanel(DrawingApp drawingApp) {
	      this.drawingApp = drawingApp ;
	      setBackground(Color.WHITE) ;
	      setPreferredSize(new Dimension(300,300)) ;
	 }
	   @Override
	   protected void paintComponent(Graphics graphics) {
	      // Paint the background
	      super.paintComponent(graphics) ;
	   }
	   
	   public void notifyForUpdate() {
		   repaint() ;		
		}
	   
	}