package Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class DepartButton extends JButton implements ActionListener{
	private final DrawingApp drawingApp ;
	
	public DepartButton(DrawingApp drawingApp)	{
	      super("Select the departure") ; // Button's text
			
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		drawingAppModel.setDepartHex();
		
	}

}
