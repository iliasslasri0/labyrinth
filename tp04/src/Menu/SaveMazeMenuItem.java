package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		String fileName = JOptionPane.showInputDialog(drawingApp, "Name of the File");
		if(fileName!=null) {
			
		try {
			drawingApp.getDrawingAppModel().saveToTextFile(".\\data\\"+fileName+".txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}
	}
