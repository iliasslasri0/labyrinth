package iu;

import java.awt.* ;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.event.*;

import Hex.Hex;

import javax.swing.JFileChooser;
import javax.swing.JPanel;


// modèle : Data & Methods
public class DrawingAppModel{
	
	
	private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
	private int NmbrOfcolumns;
    private int NmbrOfrows;
    private boolean departurechoosed =false;
    private boolean arrivalchoosed =false;
	private int current_x = -1;
	private int current_y =-1;
	private Hex[][] hexes;
	private boolean modified = false ;
	private Point mousePosition;
	private File file;
	private Hex arrivalHex;
	private Hex departHex;
	private boolean departEncours =false;
	private boolean arrivalEncours =false;
	
	private int a_x;
	private int a_y;
	private int d_x;
	private int d_y;

	private Hex hexprev;
	 
    public DrawingAppModel(int NmbrOfcolumns,int NmbrOfrows) {
    	this.NmbrOfcolumns=NmbrOfcolumns;
    	this.NmbrOfrows = NmbrOfrows;
    	this.departurechoosed = false;
    	this.arrivalchoosed=false;
    	hexes = new Hex[NmbrOfcolumns][NmbrOfrows];
    	for(int i=0;i<NmbrOfcolumns;i++) {
        	for(int j=0;j<NmbrOfrows;j++) {
        		hexes[i][j] = new Hex(j,i,"E");
        	}
        }
    	hexprev =  hexes[0][0];
    }
    
    
	public void addObserver(ChangeListener listener) {
		listeners.add(listener) ;
	}
	
	public void stateChanged() {
		// TODO Auto-generated method stub
		ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }
		
	}
	
    public void mousePressed(final MouseEvent e) {
    	mousePosition = e.getPoint();
        if (current_x != -1 && current_y != -1) {
        	if(hexes[current_y][current_x].getLabel() == "W") {
        		hexes[current_y][current_x].setLabel("E");
        	}else if(hexes[current_y][current_x].getLabel() == "E" | hexes[current_y][current_x].getLabel() == "C"){
			if (hexes[current_y][current_x].equals(departHex)) {
							departurechoosed = false;
							departHex = null;
			        		}else if (hexes[current_y][current_x].equals(arrivalHex)) {
			        			arrivalchoosed = false;
			        			arrivalHex = null;
			        		}
        		hexes[current_y][current_x].setLabel("W");
        	}
        	if (departEncours ) {
        		hexes[current_y][current_x].setLabel("E");
        		departHex = hexes[current_y][current_x];
        		d_x = current_x;
        		d_y = current_y;
        		departEncours = false;
        		departurechoosed = true;
        	}
        	if (arrivalEncours ) {
        		hexes[current_y][current_x].setLabel("E");
        		arrivalHex = hexes[current_y][current_x];
        		a_x = current_x;
        		a_y = current_y;
        		arrivalEncours = false;
        		arrivalchoosed = true;
        	}
        	stateChanged();
        }
        stateChanged();
        modified = true;
    }
    
    public void mouseMoved(final MouseEvent e) {
        mousePosition = e.getPoint();
        stateChanged();
    }

	public int getNmbrOfcolumns() {
		return NmbrOfcolumns;
	}

	public void setNmbrOfcolumns(int NmbrOfcolumns) {
		this.NmbrOfcolumns = NmbrOfcolumns;
	}

	public int getNmbrOfrows() {
		return NmbrOfrows;
	}

	public void setNmbrOfrows(int NmbrOfrows) {
		this.NmbrOfrows = NmbrOfrows;
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
	
	public void createHexes(final int rows, final int columns) {
		hexes = new Hex[rows][columns];
		for(int i=0;i<columns;i++) {
        	for(int j=0;j<rows;j++) {
        		hexes[j][i] = new Hex(j,i,"E");
        	}
        }
	}
	
	public Hex[][] getHexes(){
		return hexes;
	}


	public void setMousePosition(Point mousePosition ) {
		this.mousePosition=mousePosition;
	}


	public Point getMousePosition() {
		return mousePosition;
	}


	public void setcurrent_x(int column) {
		this.current_x = column;
		
	}


	public void setcurrent_y(int row) {
		// TODO Auto-generated method stub
		this.current_y = row;
	}


	public int getcurrent_y() {
		// TODO Auto-generated method stub
		return current_y;
	}

	public int getcurrent_x() {
		// TODO Auto-generated method stub
		return current_x;
	}
	
	
	/**
	 * This method saves the state of the maze into a text file
	 */
	public final void saveToTextFile()throws FileNotFoundException{

		File file = new File(".\\data\\labyrinthe.maze");
		this.setcurrent_file(file);
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int lineNum = 0; lineNum < this.NmbrOfrows; lineNum++) {
				for (int columNum=0; columNum < this.NmbrOfcolumns; columNum++ ) {
					pw.print(this.hexes[columNum][lineNum].getLabel());
					
				}
				pw.println();
			}
		}catch(Exception ex) {	
		}
		stateChanged();
	}
	
	public final void saveToTextFile(String fileName)throws FileNotFoundException{

		try (PrintWriter pw = new PrintWriter(fileName)) {
			for (int lineNum = 0; lineNum < this.NmbrOfrows; lineNum++) {
				for (int columNum=0; columNum < this.NmbrOfcolumns; columNum++ ) {
					pw.print(this.hexes[columNum][lineNum].getLabel());
					
				}
				pw.println();
			}
		}catch(Exception ex) {	
		}
		stateChanged();
	}

	private void setcurrent_file(File file) {
		this.file = file;
		
	}


	public File getFile() {
		// TODO Auto-generated method stub
		return file;
	}


	public Hex getArrivalHex() {
		return arrivalHex;
	}


	public void setArrivalHex() {
		arrivalEncours= true;
	}


	public Hex getDepartHex() {
		return departHex;
	}


	public void setDepartHex() {
		
		departEncours = true;
		
	}
	
	public boolean getIfdepartEncours() {
		return departEncours;
	}


	public int getA_x() {
		return a_x;
	}
	
	public int getA_y() {
		return a_y;
	}
	
	public int getD_x() {
		return d_x;
	}
	
	public int getD_y() {
		return d_y;
	}


	public void resetAll() {
		// TODO Auto-generated method stub
		for(int i=0;i<NmbrOfcolumns;i++) {
        	for(int j=0;j<NmbrOfrows;j++) {
        		hexes[i][j] = new Hex(j,i,"E");
        	}
        }
		stateChanged();
	}


	public void mouseDragged(MouseEvent e) {
		mousePosition = e.getPoint();
        if (current_x != -1 && current_y != -1) {
        	
        	if(!hexprev.equals(hexes[current_y][current_x])) {
        		if(hexes[current_y][current_x].getLabel() == "W") {
                	hexes[current_y][current_x].setLabel("E");
        		}else if(hexes[current_y][current_x].getLabel() == "E" | hexes[current_y][current_x].getLabel() == "C"){
        			if (hexes[current_y][current_x].equals(departHex)) {
        							departurechoosed = false;
        							departHex = null;
        			        		}else if (hexes[current_y][current_x].equals(arrivalHex)) {
        			        			arrivalchoosed = false;
        			        			arrivalHex = null;
        			        		}
                		hexes[current_y][current_x].setLabel("W");
                		
                	}
                	
                	stateChanged();
                	 	
        	}
        	hexprev = hexes[current_y][current_x];
        	modified = true;
        }
        stateChanged();
		
	}


	public boolean isModified() {
		return modified;
	}
}
