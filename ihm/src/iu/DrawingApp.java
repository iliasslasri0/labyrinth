package iu;
import model.*;

import javax.swing.* ;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Menu.DrawingMenuBar;

//View : interface
public class DrawingApp extends JFrame implements ChangeListener{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar ;
	private final WindowPanel windowPanel ;
	private DrawingAppModel drawingAppModel = new DrawingAppModel();
	
	public DrawingApp() {
      super("Labyrinthe") ;
		
      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
      
		
      setContentPane(windowPanel = new WindowPanel(this)) ;
      // Window content creation
      		
      //drawingAppModel.addObserver(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
      pack() ;
      setVisible(true) ;
   }

@Override
public void stateChanged(ChangeEvent e) {
	// TODO Auto-generated method stub
	windowPanel.notifyForUpdate() ;	
		
	}

}