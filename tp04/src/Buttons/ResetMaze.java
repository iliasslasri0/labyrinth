package Buttons;

import java.awt.Color;
import java.awt.Font;
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
	      this.setFont(new Font("Arial", Font.HANGING_BASELINE , 20));
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		drawingApp.getDrawingAppModel().resetAll();
	}
	}

