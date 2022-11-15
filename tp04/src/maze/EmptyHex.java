package maze;

public class EmptyHex extends MazeHex {
	
	/**
	 * 
	 * @param x Abscissa of a Hexagon
	 * @param y ordinate of a Hexagon
	 */
	public EmptyHex(Maze maze,int x,int y) {
		super(x,y,"E");
	}
	
}
