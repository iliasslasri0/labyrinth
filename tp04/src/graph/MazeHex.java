package graph;

import java.util.*;

public class MazeHex implements Vertex {
	List<MazeHex> neighborsOfHex;
	private int x;
	private int y;
	private final String label;
	
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return abscisse de la case (l'Hexagone)
	 */
	
	public int getX() {
		return H.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @return Ordonné de la case (l'Hexagone)
	 */
	public int getY() {
		return H.y;
	}
	
	/**
	 * @return Type de la case
	 */
	
	public final String getLabel() {
		return label;
		
	}
}
