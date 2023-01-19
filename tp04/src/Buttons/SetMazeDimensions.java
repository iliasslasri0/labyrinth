package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class SetMazeDimensions extends JButton implements ActionListener{

	   private final DrawingApp drawingApp ;
		
	   public SetMazeDimensions(DrawingApp drawingApp)	{
	      super("Set maze dimensions") ; // Button's text
			
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		String x = JOptionPane.showInputDialog("Type the nombre of columns : max is 24");
		drawingApp.getDrawingAppModel().setNmbrOfcolumns(Integer.parseInt(x));
		drawingApp.getDrawingAppModel().stateChanged();
		
		x = JOptionPane.showInputDialog("Type the nombre of rows : max is 15");
		drawingApp.getDrawingAppModel().setNmbrOfrows(Integer.parseInt(x));
		drawingApp.getDrawingAppModel().stateChanged();
	}
	}