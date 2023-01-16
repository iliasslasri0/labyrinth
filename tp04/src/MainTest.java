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
		Maze maze = new Maze(10,10);
		
		//System.out.println(maze.maze.length);
		//System.out.println(maze.maze[0].length);
		maze.initFromTextFileX("C:\\Users\\user\\inf103tp\\tp04\\data\\labyrinthe.maze");
		
		// [colonne][line]
		MazeHex d = maze.maze[0][0];
		MazeHex a = maze.maze[8][1];
		
		ShortestPathsImpl path;
		
		path = dij.dijkstra(maze, d, a);
	
		
		List<Vertex> chemin = path.getShortestPath(a);

		
		PrintWriter out = new PrintWriter("C:\\\\Users\\\\user\\\\inf103tp\\\\tp04\\\\data\\\\labyrinthe.maze");
		for (int i=0;i<maze.getsizeMazeLine() ;i++) {
			for (int j=0;j<maze.getsizeMazeColum();j++) {
				if (chemin.contains(maze.maze[j][i])) {
					
					out.print('.');
				}else if((maze.maze[j][i]).isWall()) {
					out.print("W");
					
				}else {
					out.print("E");
				}
			}
			out.println();
		}
		out.close();

	}
	
	
}