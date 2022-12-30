package Hex;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import iu.DrawingApp;
import model.DrawingAppModel;


public class HexJPanelMouseListener extends MouseAdapter implements MouseListener{
	DrawingApp drawingApp ;
	public boolean bl2 = false;
	public HexJPanelMouseListener(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp ;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		//String options[]={ "Wall Hex", "Arrival Hex", "Departure Hex", "Empty Hex"};
		//String option = JOptionsPane.showOptionDialog(null," What's the type of that Hex ","Select the type you want",0,4,null,options,options[0]); 
		bl2 =true;
	}
}
