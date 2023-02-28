package Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class DepartButton extends JButton implements ActionListener{
	private final DrawingApp drawingApp ;
	
	public DepartButton(final DrawingApp drawingApp)	{
	      super("Select the departure") ; // Button's text
	      this.setBackground(Color.YELLOW);
	      this.setFont(new Font("Arial", Font.BOLD, 16));
	      this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	      
	   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		drawingAppModel.setDepartHex();
	}

}
