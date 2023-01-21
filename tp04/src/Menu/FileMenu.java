package Menu;

import javax.swing.* ;

import iu.DrawingApp;

public class FileMenu extends JMenu {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final QuitMenuItem quitMenuItem ;
	private final SaveMazeMenuItem saveMazeMenuItem;
	
	public FileMenu(DrawingApp drawingApp) {
		super("File") ; // Text of the menu

      // Create and add menu items

		add(quitMenuItem = new QuitMenuItem(drawingApp)) ;
		add(saveMazeMenuItem = new SaveMazeMenuItem(drawingApp));
   }
}