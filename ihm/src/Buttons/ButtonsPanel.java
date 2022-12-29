package Buttons;

import java.awt.*;
import javax.swing.* ;

import iu.DrawingApp;

public class ButtonsPanel extends JPanel {
	
   private final ColorIndicator colorIndicator ;
   private final ColorChooserButton colorChooser ;
   private final EraseSegmentButton eraseSegment ;
	
   public ButtonsPanel(DrawingApp drawingApp) {
	   drawingApp.setLayout(new GridLayout(3,1)) ; // 3 row, 1 columns
		
	   add(colorIndicator = new ColorIndicator(drawingApp)) ;
	   add(colorChooser   = new ColorChooserButton(drawingApp)) ;
	   add(eraseSegment   = new EraseSegmentButton(drawingApp)) ;
   }
   public void notifyForUpdate() {
	   colorIndicator.notifyForUpdate() ;
	   eraseSegment.notifyForUpdate() ;
	}
}

