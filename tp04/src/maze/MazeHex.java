package maze;

import java.util.*;

import graph.Vertex;

import java.io.*;

public class MazeHex implements Vertex {
	private Maze maze;
	List<MazeHex> neighborsOfHex;
	private int x;
	private int y;
	private String label;
	
	public MazeHex(int x,int y,String label) throws Exception {
		if (!(label.equals("A")) && !(label.equals("D")) && !(label.equals("E")) && !(label.equals("W"))) {
			 throw new IOException("Enter a valid type of box, please!");
		}
		if (x> maze.sizeMazeColum || y> maze.sizeMazeLine) {
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
		return this.label;
		
	}


	@Override
	public void minDistance(Vertex V, int d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int minDistance(Vertex V) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int distance(Vertex pivot, Vertex succ) {
		// TODO Auto-generated method stub
		return 0;
	}
}
