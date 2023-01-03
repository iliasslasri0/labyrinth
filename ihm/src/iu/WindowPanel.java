package iu;

import javax.swing.* ;

import Buttons.ButtonsPanel;
import Hex.HexesJPanel;

import java.awt.*;

public class WindowPanel extends JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private final ButtonsPanel buttonsPanel ;
   private final HexesJPanel panel ;
    
   public WindowPanel(DrawingApp drawingApp) {
      setLayout(new BorderLayout()) ;
		
      add(panel = new HexesJPanel(drawingApp),BorderLayout.CENTER);
      add(buttonsPanel = new ButtonsPanel (drawingApp), BorderLayout.SOUTH) ;
      
   }
   public void notifyForUpdate() {
	   panel.notifyForUpdate() ;
	   
	}
}
