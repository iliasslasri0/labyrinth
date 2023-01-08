package iu;

import javax.swing.* ;

import Buttons.ButtonsPanel;

import Hex.HexesJPanel;

import java.awt.*;
import java.util.ArrayList;

public class WindowPanel extends JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private ButtonsPanel buttonsPanel ;
   private HexesJPanel panel ;
    
   public WindowPanel(DrawingApp drawingApp) {
      setLayout(new BorderLayout()) ;
		
      this.add(panel = new HexesJPanel(10,10,40),BorderLayout.CENTER);
      this.add(buttonsPanel = new ButtonsPanel (drawingApp), BorderLayout.SOUTH) ;
      
   }
   public void notifyForUpdate() {
	  // panel.notifyForUpdate() ;
	   
	}
}
