package maze;

import graph.Vertex;

import java.io.*;

public class MazeHex implements Vertex {
	private int x;
	private int y;
	private String label;
	
	public MazeHex(Maze maze, int x, int y, String label) throws Exception {
		if (!(label.equals("A")) && !(label.equals("D")) && !(label.equals("E")) && !(label.equals("W"))) {
			 throw new IOException("Enter a valid type of box, please!");
		}
		if (x > maze.getsizeMazeColum() || y> maze.getsizeMazeLine()) {
			throw new IOException("Enter a valid coordnates, please!");
		}
		this.x=x;
		this.y=y;
		this.label = label;
	}
	
	
	/**
	 * 
	 * @return l'abscisse de la case (l'Hexagone)
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
		return this.label;	
	}
}
