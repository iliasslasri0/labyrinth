package Maze;

import java.util.*;

public class MazeHex{
	List<MazeHex> neighborsOfHex;
	int x;
	int y;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX(MazeHex H) {
		return H.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY(MazeHex H) {
		return H.y;
	}
}
