package model;

import java.awt.* ;



import java.util.ArrayList;

import javax.swing.event.*;

import Hex.Hex;

import javax.swing.JPanel;

public class DrawingAppModel extends JPanel {

   
	/**
	 * 
	 */
	private Color currentColor= Color.WHITE;
	private static final long serialVersionUID = 1L;
	private final Polygon hexagon = new Polygon();
	private Hex currentHex = null ;
	private Hex selectedHex = null ;
    private Hex[][] hexes ;
    private int height =5;
    private int width =5;
	private boolean modified = false;
   // getters et setters
   
    private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
    
    public final void setCurrentColor(Color currentColor) {
    	   if (this.currentColor != currentColor) {
    	      this.currentColor = currentColor;
    	      modified = true ;
    	      stateChanged() ;
    	   }
    	}
    public Color getCurrentColor() {
    	return this.currentColor;
    }
    
    public void stateChanged() {
		   ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }
		}
   
    public void setHex(int x, int y, String Label) {
		this.hexes[x][y] = new Hex(x,y,Label);
		modified = true ;
		stateChanged();
	}
    public Hex[][] getHexes() {return hexes;}
	public void setBoxes(Hex[][] hexes) {
		this.hexes = hexes;
		modified = true ; 
		stateChanged();
	}
   
    
	public void addObserver(ChangeListener listener) {
		listeners.add(listener) ;
	}
	
    
	public DrawingAppModel() {
		hexes =new Hex[height][width];
		for(int i = 0 ; i<height ; i++) {
			for(int j = 0 ; j< width ; j++) {
				hexes[i][j] = new Hex(i, j , "W");
			}
		}
	}
	
   public void setCurrentHex(Hex currentHex) {
		if(this.currentHex != currentHex) {
			this.currentHex = currentHex;
			modified = true;
			stateChanged();
			}	
	}

	public Hex getSelectedHex() {
		// TODO Auto-generated method stub
		return selectedHex;
	}
	public boolean isModified() {
		// TODO Auto-generated method stub
		return modified;
	}
	
}
