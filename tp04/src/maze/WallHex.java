package maze;

public class WallHex extends MazeHex {
	
	/**
	 * 
	 * @param x Abscissa of a Hexagon
	 * @param y ordinate of a Hexagon
	 * @throws Exception 
	 */
	public WallHex(Maze maze,int x,int y) throws Exception {
		super(x,y,"W");
	}
	
	
}
