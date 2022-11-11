package graph;
import java.util.*;

public class Maze implements Graph {
	final int sizeMaze = 10;
	MazeHex[][] maze=new MazeHex[sizeMaze][sizeMaze];
	
	/**
	 * @return A list of all the boxes possible to pass through
	 * 
	 */
	public List<Vertex> getAllVertexes(){
		
		ArrayList<MazeHex> allPossibleMazeHex = new ArrayList<MazeHex>();
		
		for (MazeHex h : maze ) {
			if (h.getLabel() == "E") {
				allPossibleMazeHex.add(h);
			}
		}	
	}
	
	/**
	 * @return A list of the neighbors of a box(Hexagon)
	 */
	public List<Vertex> getSuccessors(Vertex vertex){
		
		List<MazeHex> neighbors = new ArrayList<MazeHex>();
		MazeHex Hex = (MazeHex) vertex ;
		
		int x = Hex.getX();
		int y = Hex.getY();
		if (x == 0) {
			if (y == 0) {
				neighbors.add(maze[0][1]);
				neighbors.add(maze[1][0]);
			}
			else {
				neighbors.add(maze[x][y-1]);
				neighbors.add(maze[x][y+1]);
				neighbors.add(maze[x+1][y]);
				
			}
			
		}else if(x==9){
			if (y==9) {
				neighbors.add(maze[9][8]);
				neighbors.add(maze[8][9]);
			}else {
				neighbors.add(maze[x][y-1]);
				neighbors.add(maze[x][y+1]);
				neighbors.add(maze[x-1][y]);
				
			}
			
		}
		if (y== 0) {
			neighbors.add(maze[x-1][1]);
			neighbors.add(maze[x][1]);
		}else if (y==9){
			neighbors.add(maze[x+1][8]);
			neighbors.add(maze[x][18]);
		}
		else {
			neighbors.add(maze[x-1][y-1]);
			neighbors.add(maze[x-1][y+1]);
			neighbors.add(maze[x-1][y]);
			neighbors.add(maze[x][y-1]);
			neighbors.add(maze[x][y+1]);
			neighbors.add(maze[x+1][y]);
		}
		
	}
	/**
	 * @return the weight of the arc src to dst 
	 */
	public int getWeight(Vertex src, Vertex dst) {
		return 1;
		
	}
	
	public final void initFromTextFile(String fileName) {
		
	}
}
