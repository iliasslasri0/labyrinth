package iu;

import java.awt.* ;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.event.*;
import Hex.Hex;

// Model : Data & Getters & Setters
public class DrawingAppModel{
	
	
	private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;
	private int NmbrOfcolumns;
    private int NmbrOfrows;
    private boolean departurechoosed =false;
    private boolean arrivalchoosed =false;
	private int current_x = -1; // to refer to the box that includes the mouse
	private int current_y =-1; // to refer to the box that includes the mouse
	private Hex[][] hexes;
	private boolean modified = false ; // to know if the maze has been modified or not,
										// to propose to the user a save option while quiting if modified
	private Point mousePosition;
	private File file = new File(".\\data\\labyrinthe.maze"); // this is the file that we use to store our
													// maze and solve there the applaud it to the interface
	private Hex arrivalHex;
	private Hex departHex;
	private boolean departEncours =false; // indicates if we are proceding to the chosing of the departure
	private boolean arrivalEncours =false;// or the arrival ( the buttons (choose a departure/arrival are On)
	
	private int a_x; // coordinates of the arrival
	private int a_y;
	private int d_x;// coordinates of the departure
	private int d_y;

	private Hex hexprev; // used in the dragging function to avoid the excessive change of state 
						//when the user is dragging the mouse
	 
    public DrawingAppModel(final int NmbrOfcolumns,final int NmbrOfrows) {
    	this.NmbrOfcolumns=NmbrOfcolumns;
    	this.NmbrOfrows = NmbrOfrows;
    	this.departurechoosed = false;
    	this.arrivalchoosed=false;
    	hexes = new Hex[NmbrOfcolumns][NmbrOfrows];
    	for(int i=0;i<NmbrOfcolumns;i++) {
        	for(int j=0;j<NmbrOfrows;j++) {
        		hexes[i][j] = new Hex(j,i,false,false);
        	}
        }
    	hexprev =  hexes[0][0];
    }
    
    
	public void addObserver(final ChangeListener listener) {
		listeners.add(listener) ;
	}
	
	public void stateChanged() {
		ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }
		
	}
	
	public Hex gethexprev() {
		return hexprev;
	}
	
	public void sethexprev(Hex hex) {
		hexprev = hex;
	}
	
	public int getNmbrOfcolumns() {
		return NmbrOfcolumns;
	}

	public void setNmbrOfcolumns(final int NmbrOfcolumns) {
		this.NmbrOfcolumns = NmbrOfcolumns;
	}

	public int getNmbrOfrows() {
		return NmbrOfrows;
	}

	public void setNmbrOfrows(final int NmbrOfrows) {
		this.NmbrOfrows = NmbrOfrows;
	}

	public boolean isDeparturechoosed() {
		return departurechoosed;
	}

	public void setDeparturechoosed(final boolean departurechoosed) {
		this.departurechoosed = departurechoosed;
	}

	public boolean isArrivalchoosed() {
		return arrivalchoosed;
	}

	public void setArrivalchoosed(final boolean arrivalchoosed) {
		this.arrivalchoosed = arrivalchoosed;
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
	
	public int getCurrent_x() {
		return current_x;
	}
	
	public int getCurrent_y() {
		return current_y;
	}

	public void setcurrent_y(int row) {
		this.current_y = row;
	}


	public int getcurrent_y() {
		return current_y;
	}

	public int getcurrent_x() {
		return current_x;
	}
	
	public void setcurrent_file(File file) {
		this.file = file;
		
	}

	public File getFile() {
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

	public void setdepartHex(Hex hex) {
		departHex = hex;
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

	public boolean isModified() {
		return modified;
	}
	
	public void setDepartHex() {
		departEncours = true;
	}

	public void setArrivalHex(Hex hex) {
		arrivalHex = hex;
	}


	public void setD_x(int current_x2) {
		d_x=current_x2;
		
	}
	
	public void setD_y(int current_y2) {
		d_y=current_y2;
		
	}
	
	public void setA_x(int current_x2) {
		a_x=current_x2;
		
	}
	
	public void setA_y(int current_y2) {
		a_y=current_y2;
		
	}


	public void setDepartureEncours(boolean b) {
		departEncours = b;
		
	}


	public boolean getIfarrivalEncours() {
		return arrivalEncours;
	}


	public void setArrivalEncours(boolean b) {
		arrivalEncours = b;
		
	}


	public void setModified(boolean b) {
		modified = b;
	}
}
