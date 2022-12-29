package Buttons;

import javax.swing.* ;

import iu.DrawingApp;

public class EraseSegmentButton extends JButton {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private final DrawingApp drawingApp ;
	
   public EraseSegmentButton(DrawingApp drawingApp) {
      super("Erase segment") ; // Button's text
		
      this.drawingApp = drawingApp ;		
   }
   public void notifyForUpdate() {
	   DrawingApp selected = drawingApp.getDrawingAppModel().getHexagon(horizontalAlignment, horizontalAlignment) ;

	   setEnabled(selected != null) ;		
	}
}