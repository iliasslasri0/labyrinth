package iu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;
		
	   public DrawingPanel(DrawingApp drawingApp) {
	      this.drawingApp = drawingApp ;
			
	      setBackground(Color.WHITE) ;

	      // for pack() instruction
	      setPreferredSize(new Dimension(300,300)) ;  
	   }
	}