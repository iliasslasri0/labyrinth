package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import iu.DrawingApp;

public class SaveMazeMenuItem extends JMenuItem implements ActionListener{
	
	private final DrawingApp drawingApp ;

	public SaveMazeMenuItem(DrawingApp drawingApp) {
		super("Save your maze") ; // Text of menu item

		this.drawingApp = drawingApp ;
		addActionListener(this) ;
   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		File file = null;
		fileChooser.setCurrentDirectory(new File(".")); //sets current directory

		int response = fileChooser.showSaveDialog(null); //select file to save( giving a name to the file that we are saving)
		
		if(response == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getAbsolutePath());
		}
		if(file !=null) {
		try {
			drawingApp.getController().saveToTextFile(file+".txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		}
		
	}
	}
