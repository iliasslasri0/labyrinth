package iu;
import java.awt.Dimension;

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
	private DrawingAppModel drawingAppModel = new DrawingAppModel(10,10);
	
	public DrawingApp() {
      super("Labyrinthe") ;

      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
      
      
      this.setPreferredSize(new Dimension(1000,1000));
      setContentPane(windowPanel = new WindowPanel(this)) ;
      // Window content creation
      drawingAppModel.addObserver(this);
      //drawingAppModel.addObserver(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
      pack() ;
      setVisible(true) ;
   }

@Override
public void stateChanged(ChangeEvent e) {

	windowPanel.notifyForUpdate() ;	
		
	}

public DrawingAppModel getDrawingAppModel() {

	return drawingAppModel;
}

public void setDrawingAppModel(DrawingAppModel drawingAppModel) {
	   this.drawingAppModel = drawingAppModel;
	
}

}