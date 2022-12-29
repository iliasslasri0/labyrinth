package Buttons;

import java.awt.Dimension;

import javax.swing.* ;

import iu.DrawingApp;

public class ColorIndicator extends JPanel {

   private final DrawingApp drawingApp ;
	
   public ColorIndicator(DrawingApp drawingApp) {
      this.drawingApp = drawingApp ;
      
      drawingApp.setPreferredSize(new Dimension(1000,1000)) ;
   }
}