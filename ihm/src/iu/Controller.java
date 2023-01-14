package iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Controler
public class Controller{
	private DrawingApp drawingApp;
	private DrawingAppModel drawingAppModel;
	
	public Controller(DrawingApp drawingApp,DrawingAppModel drawingAppModel) {
		
		this.drawingApp = drawingApp;
		this.drawingAppModel = drawingAppModel;
	}


}
