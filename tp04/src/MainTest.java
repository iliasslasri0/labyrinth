import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import graph.*;
import maze.*;
import maze.Maze;
import maze.MazeHex;

public class MainTest {
	public static void main(String[] args) throws Exception {
		Dijkstra dij = new Dijkstra();
		//Maze(nombre de colonnes , Nmbr de lines)
		Maze maze = new Maze(10,16);
		
		//System.out.println(maze.maze.length);
		//System.out.println(maze.maze[0].length);
		maze.initFromTextFile("C:\\Users\\user\\inf103tp\\tp04\\data\\labyrinthe.maze");
		
		// [colonne][line]
		MazeHex d = maze.maze[3][14];
		MazeHex a = maze.maze[0][0];
		
		ShortestPathsImpl path;
		
		path = dij.dijkstra(maze, d, a);
	
		
		List<Vertex> chemin = path.getShortestPath(a);

		
		
		for (int i=0;i<maze.getsizeMazeLine() ;i++) {
			for (int j=0;j<maze.getsizeMazeColum();j++) {
				if (chemin.contains(maze.maze[j][i])) {
					
					System.out.print('.');
				}else if((maze.maze[j][i]).isWall()) {
					System.out.print("W");
					
				}else {
					System.out.print("E");
				}
			}
			System.out.print("\n");
		}
		maze.saveToTextFile("C:\\Users\\user\\inf103tp\\tp04\\data\\labirinther.maze");

	}
	
	
}