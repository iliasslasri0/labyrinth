import graph.*;
import maze.*;
import maze.Maze;
import maze.MazeHex;

public class MainTest {
	public static void main(String[] args) throws Exception {
		Dijkstra dij = new Dijkstra();
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("C:\\Users\\user\\inf103tp\\tp04\\data\\labyrinthe.maze");
		
		MazeHex d= maze.maze[0][0];
		MazeHex a= maze.maze[9][9];
		
		ProcessedVertexesImpl processedVertexs = new ProcessedVertexesImpl();
		MinDistanceImpl minDistance = new MinDistanceImpl();
		ShortestPathsImpl path = new ShortestPathsImpl();
		
		path = dij.dijkstra(maze,d,a,processedVertexs,minDistance);
		
		for ( Vertex key : path.keySet()) {
			System.out.println(((MazeHex)key).getLabel() );
		}
		
	}
	
	
}