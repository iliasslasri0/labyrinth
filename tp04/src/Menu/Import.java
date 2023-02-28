package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ModuleLayer.Controller;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import iu.DrawingApp;

public class Import extends JMenuItem implements ActionListener{

	private final DrawingApp drawingApp ;
	private Controller controller;
	public Import(DrawingApp drawingApp) {
		super("Import a Maze") ; // Text of menu item

		this.drawingApp = drawingApp ;
		addActionListener(this) ;
   }
	/**
	* Responds to an action event triggered by selecting the "Save" option from the menu. Opens a file chooser dialog to
	* prompt the user to select a file to save the current state of the drawing application to. If a file is selected,
	* calls the initFromTextFile and saveToTextFile methods to save the drawing application state to the
	* selected file and a default file respectively.
	@param evt the action event that occurred
	*/
	@Override
	public void actionPerformed(ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		File file = null;
		fileChooser.setCurrentDirectory( new File(".")); //sets current directory

		int response = fileChooser.showSaveDialog(null); //select file to save( giving a name to the file that we are saving)
		
		if(response == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getAbsolutePath());
		}
		if(file !=null) {
		try {
			drawingApp.getController().initFromTextFile(file);
			drawingApp.getController().saveToTextFile(".\\data\\labyrinthe.maze");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}	
	}
}
