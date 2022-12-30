package iu;
import model.*;
import javax.swing.* ;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Buttons.ButtonsPanel;

public class DrawingApp extends JFrame implements ChangeListener{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar ;
	private final WindowPanel windowPanel ;
	private DrawingAppModel drawingAppModel = new DrawingAppModel();
	
	public DrawingApp() {
      super("Drawing Application") ;
		
      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
      
		
      setContentPane(windowPanel = new WindowPanel(this)) ;
      // Window content creation
      		
      drawingAppModel.addObserver(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
      pack() ;
      setVisible(true) ;
   }

public DrawingAppModel getDrawingAppModel() {
	return drawingAppModel;
}

public void setDrawingAppModel(DrawingAppModel drawingAppModel) {
	this.drawingAppModel = drawingAppModel;
}

@Override
public void stateChanged(ChangeEvent e) {
	// TODO Auto-generated method stu
	windowPanel.notifyForUpdate() ;	
		
	}

}