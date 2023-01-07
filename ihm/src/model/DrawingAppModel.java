package model;

import java.awt.* ;




import java.util.ArrayList;

import javax.swing.event.*;


import javax.swing.JPanel;
import Hex.HexJPanel;


// modèle : Data & Methods
public class DrawingAppModel extends JPanel {

   
	/**
	 * 
	 */
	private Color currentColor= Color.WHITE;
	private static final long serialVersionUID = 1L;

	private ArrayList<ArrayList<HexJPanel>> hexes;

   
    private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
    
    public ArrayList<ArrayList<HexJPanel>> getHexes() {
		return hexes;
    
    }
    
	
}
