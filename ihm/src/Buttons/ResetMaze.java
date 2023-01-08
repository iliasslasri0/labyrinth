package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class ResetMaze extends JButton implements ActionListener{

	   private final DrawingApp drawingApp ;
		
	   public ResetMaze(DrawingApp drawingApp)	{
	      super("Reset the maze") ; // Button's text
			
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Used twice
	      DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel() ;

	      // Show JColorChooser dialog		
	      Color newColor = JColorChooser.showDialog(drawingApp,
	                                                "Change segment color",
							drawingAppModel.getCurrentColor()) ;
	      // Changing color triggers refresh	
	      if (newColor != null)
	         drawingAppModel.setCurrentColor(newColor) ;
	}
	}

