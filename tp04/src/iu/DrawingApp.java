package iu;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	private  DrawingAppModel drawingAppModel;
	private Controller controller;
	
	public DrawingApp() throws IOException {
		
		super("Labyrinthe") ;
		drawingAppModel = new DrawingAppModel(24,15);
		controller = new Controller(this, drawingAppModel);
		try {
			drawingAppModel.saveToTextFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
      
      
      this.setPreferredSize(new Dimension(1000,1000));
      setContentPane(windowPanel = new WindowPanel(this)) ;
      // Window content creation
      drawingAppModel.addObserver(this);
      //drawingAppModel.addObserver(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
      pack();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
public Controller getController() {

	return controller;
}

}