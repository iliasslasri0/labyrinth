package iu;

import java.awt.* ;




import java.util.ArrayList;

import javax.swing.event.*;


import javax.swing.JPanel;


// modèle : Data & Methods
public class DrawingAppModel implements ChangeListener{
	
	
	private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
	private int width;
    private int height;
    private boolean departurechoosed;
    private boolean arrivalchoosed;
    
    public DrawingAppModel(int width,int height) {
    	this.width=width;
    	this.height = height;
    	this.departurechoosed = false;
    	this.arrivalchoosed=false;
    	
    }
    
    
	public void addObserver(ChangeListener listener) {
		listeners.add(listener) ;
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return true;
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }
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
	
}
