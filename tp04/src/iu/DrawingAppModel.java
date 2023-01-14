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
	private int width;
    private int height;
    private boolean departurechoosed =false;
    private boolean arrivalchoosed;
	private int current_x = -1;
	private int current_y =-1;
	private Hex[][] hexes;
	private boolean mousePressed;
	private boolean modified = false ;
	private Point mousePosition;
	private File file;
	private Hex arrivalHex;
	private Hex departHex;
	private boolean departEncours;
	
	 
    public DrawingAppModel(int width,int height) {
    	this.width=width;
    	this.height = height;
    	this.departurechoosed = false;
    	this.arrivalchoosed=false;
    	hexes = new Hex[width][height];
    	for(int i=0;i<width;i++) {
        	for(int j=0;j<height;j++) {
        		hexes[j][i] = new Hex(j,i,"E");
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
		/*ChangeEvent evt = new ChangeEvent(this) ;
		   
		   for (ChangeListener listener : listeners) {
		      listener.stateChanged(evt);
		   }*/
		
	}
	
    public void mousePressed(final MouseEvent e) {
    	mousePosition = e.getPoint();
        if (current_x != -1 && current_y != -1) {
        	if(hexes[current_y][current_x].getLabel() == "W") {
        		hexes[current_y][current_x].setLabel("E");
        	}else if(hexes[current_y][current_x].getLabel() == "E"){
        		hexes[current_y][current_x].setLabel("W");
        	}
        	if (departEncours ) {
        		hexes[current_y][current_x].setLabel("E");
        		departHex = hexes[current_y][current_x];
        		departEncours = false;
        		departurechoosed = true;
        	}
        	
        	//System.out.println(hexes[current_y][current_x].getLabel());
        	stateChanged(e);
        }
        stateChanged(e);
        mousePressed = true;
    }
    
    public void mouseMoved(final MouseEvent e) {
        mousePosition = e.getPoint();
        stateChanged(e);
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
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setCurrentDirectory(new File(".")); //sets current directory
		
		int response = fileChooser.showOpenDialog(null); //select file to open
		//int response = fileChooser.showSaveDialog(null); //select file to save
		File file = null ;
		if(response == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			this.setcurrent_file(file);
		}
		 
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int lineNum = 0; lineNum < this.width; lineNum++) {
				for (int columNum=0; columNum < this.height; columNum++ ) {
					pw.print(this.hexes[lineNum][columNum].getLabel());
					
				}
				pw.println();
			}
		}catch(Exception ex) {	
		}
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


	public void setArrivalHex(Hex arrivalHex) {
		arrivalHex = arrivalHex;
	}


	public Hex getDepartHex() {
		return departHex;
	}


	public void setDepartHex() {
		
		departEncours = true;
		
	}
	
}