package Buttons;

import javax.swing.JButton;

import iu.DrawingApp;

public class ColorChooserButton extends JButton {

	   private final DrawingApp drawingApp ;
		
	   public ColorChooserButton(DrawingApp drawingApp)	{
	      super("Choose color") ; // Button's text
			
	      this.drawingApp = drawingApp ;
	   }
	}

