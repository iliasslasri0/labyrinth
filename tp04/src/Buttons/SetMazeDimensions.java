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
		String x,y;
		while (true) {
			x = JOptionPane.showInputDialog("Type the numbre of columns : max is 24");
			if (x==null){
				break;
			}
			if (Integer.parseInt(x) > 24 | Integer.parseInt(x)< 1) {
				JOptionPane.showMessageDialog( drawingApp, "Enter a valid number please!","Invalid number",JOptionPane.ERROR_MESSAGE);
			}else {
				break;
			}
		}
		
		if (x!=null) {
			drawingApp.getDrawingAppModel().setNmbrOfcolumns(Integer.parseInt(x));
			drawingApp.getDrawingAppModel().stateChanged();
		}
		
		
		
		while (true) {
			y = JOptionPane.showInputDialog("Type the numbre of rows : max is 15");
			if (y==null){
				break;
			}
			if (Integer.parseInt(y) > 15 | Integer.parseInt(y)< 1) {
				JOptionPane.showMessageDialog( drawingApp, "Enter a valid number please!","Invalid number",JOptionPane.ERROR_MESSAGE);
			}else {
				break;
			}
		}
		if (y!=null) {
			drawingApp.getDrawingAppModel().setNmbrOfrows(Integer.parseInt(y));
			drawingApp.getDrawingAppModel().stateChanged();
		}
		
	}
	}