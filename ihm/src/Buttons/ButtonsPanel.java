package Buttons;

import java.awt.*;
import javax.swing.* ;

import iu.DrawingApp;

public class ButtonsPanel extends JPanel {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private final ColorIndicator colorIndicator ;
   private final ColorChooserButton colorChooser ;
   private final EraseSegmentButton eraseSegment ;
   private final WallButton wallButton;
   public ButtonsPanel(DrawingApp drawingApp) {
	   drawingApp.setLayout(new GridLayout(3,1)) ; // 3 row, 1 columns
		
	   add(colorIndicator = new ColorIndicator(drawingApp)) ;
	   add(colorChooser   = new ColorChooserButton(drawingApp)) ;
	   add(eraseSegment   = new EraseSegmentButton(drawingApp)) ;
	   add(wallButton   = new WallButton(drawingApp)) ;
   }
   public void notifyForUpdate() {
	   colorIndicator.notifyForUpdate() ;
	   eraseSegment.notifyForUpdate() ;
	}
}

