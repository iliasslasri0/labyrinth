package graph;

import java.util.*;

public class MazeHex implements Vertex {
	List<MazeHex> neighborsOfHex;
	private int x;
	private int y;
	private String label;
	
	public void mazeHex(int x,int y, String label) {
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
	 * @return Type de la case
	 */
	
	public final String getLabel() {
		return label;
		
	}
}
