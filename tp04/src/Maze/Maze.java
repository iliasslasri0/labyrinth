package Maze;
import java.util.*;

public class Maze {
	final int sizeMaze = 10;
	ArrayList<MazeHex> maze=new ArrayList<MazeHex>(sizeMaze);
	
	public void transformToWallHex(int x,int y) {
		
	}
	public void transformToEmptyHex(int x , int y) {
	}
	
	public void transformToDepartureHex(int x,int y) {
	}
	
	public void transformToArrivalHex(int x,int y) {
	}

	public List<MazeHex> neighborsOfHex(MazeHex h) {
		List<MazeHex> neighbors = new ArrayList<MazeHex>();
		int x = h.getX(h);
		int y = h.getY(h);
		if (x == 0) {
			if (y == 0) {
				neighbors.add(maze[0][1]);
				neighbors.add(maze[1][0]);///ici 
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
		
	
		
		
	}

}