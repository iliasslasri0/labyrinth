package iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import Hex.Hex;

//Controler
public class Controller{
	private DrawingApp drawingApp;
	private DrawingAppModel drawingAppModel;
	
	public Controller(DrawingApp drawingApp,DrawingAppModel drawingAppModel) {
		
		this.drawingApp = drawingApp;
		this.drawingAppModel = drawingAppModel;
	}
	

	public void mouseMoved(final MouseEvent e) {
        drawingAppModel.setMousePosition(e.getPoint());
        drawingAppModel.stateChanged();
    }
	

	public void mousePressed(final MouseEvent e) {
		drawingAppModel.setMousePosition(e.getPoint());
		int current_x = drawingAppModel.getCurrent_x();
		int current_y = drawingAppModel.getCurrent_y();
		Hex[][] hexes= drawingAppModel.getHexes();
        if (current_x != -1 && current_y != -1) {
        	if(hexes[current_y][current_x].getLabel() == "W") {
        		hexes[current_y][current_x].setLabel("E");
        	}else if(hexes[current_y][current_x].getLabel() == "E" | hexes[current_y][current_x].getLabel() == "C"){
			if (hexes[current_y][current_x].equals(drawingAppModel.getDepartHex())) {
				drawingAppModel.setDeparturechoosed(false);
				drawingAppModel.setdepartHex(null);
			        		}else if (hexes[current_y][current_x].equals(drawingAppModel.getArrivalHex())) {
			        			drawingAppModel.setArrivalchoosed(false);
			    				drawingAppModel.setArrivalHex(null);
			        		}
        		hexes[current_y][current_x].setLabel("W");
        	}
        	if (drawingAppModel.getIfdepartEncours() ) {
        		hexes[current_y][current_x].setLabel("E");
        		drawingAppModel.setdepartHex(hexes[current_y][current_x]);
        		drawingAppModel.setD_x(current_x);
        		drawingAppModel.setD_y (current_y);
        		drawingAppModel.setDepartureEncours (false);
        		drawingAppModel.setDeparturechoosed(true);
        	}
        	if (drawingAppModel.getIfarrivalEncours() ) {
        		hexes[current_y][current_x].setLabel("E");
        		drawingAppModel.setArrivalHex(hexes[current_y][current_x]);
        		drawingAppModel.setA_x(current_x);
        		drawingAppModel.setA_y (current_y);
        		drawingAppModel.setArrivalEncours (false);
        		drawingAppModel.setArrivalchoosed(true);
        	}
        	drawingAppModel.stateChanged();
        }
        drawingAppModel.stateChanged();
        drawingAppModel.setModified(true);
    }

}
