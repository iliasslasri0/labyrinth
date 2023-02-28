package maze;

import graph.Vertex;

import java.io.*;

public abstract class MazeHex implements Vertex {
	private int x;
	private int y;
	
	public MazeHex(Maze maze, int x, int y) throws Exception {
		if (x > maze.getsizeMazeColum() || y> maze.getsizeMazeLine()) {
			throw new IOException("Enter a valid coordnates, please!");
		}
		this.x=x;
		this.y=y;
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
	 * @return boolean : true si ce hex est wall, false sinon
	 */
	public boolean isWall() {
		return false;
}

}
