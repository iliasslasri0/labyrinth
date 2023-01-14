/*package Hex;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import iu.DrawingApp;
import iu.DrawingAppModel;


public class HexJPanelMouseListener extends MouseAdapter implements MouseListener, MouseInputListener {
	DrawingApp drawingApp ;
	
	public boolean bl2 = false;
	public HexJPanelMouseListener(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp ;
	}
	
	
	@Override
    public void mouseMoved(final MouseEvent e) {
		if (drawingApp.getDrawingAppModel() !=null) {
			drawingApp.getDrawingAppModel().setMousePosition(e.getPoint());
			drawingApp.getDrawingAppModel().stateChanged(e);
		}
		
    }
    @Override
    public void mousePressed(final MouseEvent e) {
        if (drawingApp.getDrawingAppModel().getcurrent_y() != -1 && drawingApp.getDrawingAppModel().getcurrent_y() != -1) {
        	drawingApp.getDrawingAppModel().getHexes()[drawingApp.getDrawingAppModel().getcurrent_y()][drawingApp.getDrawingAppModel().getcurrent_x()].setLabel("E");
        }
    }

    
	@Override
	public void mouseReleased(MouseEvent e) {
		//String options[]={ "Wall Hex", "Arrival Hex", "Departure Hex", "Empty Hex"};
		//String option = JOptionsPane.showOptionDialog(null," What's the type of that Hex ","Select the type you want",0,4,null,options,options[0]); 
		bl2 =true;
	}
}*/
