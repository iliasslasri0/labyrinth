package iu;

import java.awt.* ;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.*;

import Hex.Hex;

import javax.swing.JPanel;


// modèle : Data & Methods
public class DrawingAppModel implements ChangeListener{
	
	
	private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
	private int width;
    private int height;
    private boolean departurechoosed;
    private boolean arrivalchoosed;
	private int current_x;
	private int current_y;
	private Hex[][] hexes;
	private boolean mousePressed;
	private boolean modified = false ;
	 
    public DrawingAppModel(int width,int height) {
    	this.width=width;
    	this.height = height;
    	this.departurechoosed = false;
    	this.arrivalchoosed=false;
    	hexes = new Hex[width][height];
    	for(int i=0;i<width;i++) {
        	for(int j=0;j<height;j++) {
        		hexes[j][i] = new Hex(j,i);
        	}
        }
    }
    
    
	public void addObserver(ChangeListener listener) {
		listeners.add(listener) ;
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return true;
	}
	

	public void stateChanged(MouseEvent e) {
		// TODO Auto-generated method stub
		ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }
	}
	
    public void mousePressed(final MouseEvent e) {
        if (current_x != -1 && current_y != -1) {
        	if(hexes[current_y][current_x].getLabel() == "W") {
        		hexes[current_y][current_x].setLabel("E");
        	}else {
        		hexes[current_y][current_x].setLabel("W");
        	}
        	
        	System.out.println(hexes[current_y][current_x].getLabel());
        	stateChanged(e);
        }
        stateChanged(e);
        mousePressed = true;
    }

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isDeparturechoosed() {
		return departurechoosed;
	}

	public void setDeparturechoosed(boolean departurechoosed) {
		this.departurechoosed = departurechoosed;
	}

	public boolean isArrivalchoosed() {
		return arrivalchoosed;
	}

	public void setArrivalchoosed(boolean arrivalchoosed) {
		this.arrivalchoosed = arrivalchoosed;
	}


	public void setcurrentXY(int column, int row) {
		this.current_x = column;
		this.current_y=row;
		
	}
	
	public void createHexes(final int rows, final int columns) {
		hexes = new Hex[rows][columns];
		for(int i=0;i<columns;i++) {
        	for(int j=0;j<rows;j++) {
        		hexes[j][i] = new Hex(j,i);
        	}
        }
	}
	
	public Hex[][] getHexes(){
		return hexes;
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
