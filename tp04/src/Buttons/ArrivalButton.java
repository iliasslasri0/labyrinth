package Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.UIManager;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class ArrivalButton  extends JButton implements ActionListener{
	private final DrawingApp drawingApp ;
	
	public ArrivalButton(DrawingApp drawingApp)	{
		
	      super("Select the Arrival") ; // Button's text
	      this.setFont(new Font("Arial", Font.HANGING_BASELINE , 20));
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	     
	   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		drawingAppModel.setArrivalHex();
	}
}
