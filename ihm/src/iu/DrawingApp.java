package iu;
import javax.swing.* ;

import Buttons.ButtonsPanel;

public class DrawingApp extends JFrame {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar ;
	private final WindowPanel windowPanel ;
   public DrawingApp() {
      super("Drawing Application") ;
		
      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
      
		
      setContentPane(windowPanel = new WindowPanel(this)) ;
      // Window content creation
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
      pack() ;
      setVisible(true) ;
   }
}