package maze;

public class EmptyHex extends MazeHex {
	
	/**
	 * 
	 * @param x Abscissa of a Hexagon
	 * @param y ordinate of a Hexagon
	 * @throws Exception 
	 */
	public EmptyHex(Maze maze,int x,int y) throws Exception {
		super(x,y,"E");
	}
	
}
