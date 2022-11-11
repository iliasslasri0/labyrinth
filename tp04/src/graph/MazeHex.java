package graph;

import java.util.*;
import java.io.*;

public class MazeHex implements Vertex {
	List<MazeHex> neighborsOfHex;
	private int x;
	private int y;
	private String label;
	
	public void mazeHex(int x,int y,String label) throws Exception {
		if (!(label.equals("A")) && !(label.equals("D")) && !(label.equals("E")) && !(label.equals("W"))) {
			 throw new IOException("Enter a valid type of box, please!");
		}
		if (x>10 || y>10) {
			throw new IOException("Enter a valid coordnates, please!");
		}
		this.x=x;
		this.y=y;
		this.label=label;
	}
	
	
	/**
	 * 
	 * @return abscisse de la case (l'Hexagone)
	 */
	public int getX() {
		return this.x;
	}
	

	
	/**
	 * 
	 * @return Ordonné de la case (l'Hexagone)
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * @return Type of the box
	 */
	
	public final String getLabel() {
		return label;
		
	}
}
