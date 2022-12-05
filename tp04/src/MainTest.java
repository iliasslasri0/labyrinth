import graph.*;
import maze.ArrivalHex;
import maze.DepartureHex;
import maze.Maze;
import maze.MazeHex;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		Dijkstra dij = new Dijkstra();
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("data/labyrinthe.maze");
		
		MazeHex d= new DepartureHex(maze,0,0);
		MazeHex a= new ArrivalHex(maze,9,9);
		
		ProcessedVertexesImpl processedVertexs = new ProcessedVertexesImpl();
		MinDistanceImpl minDistance = new MinDistanceImpl();
		ShortestPathsImpl path = new ShortestPathsImpl();
		
		path = dij.dijkstra(maze,d,a,processedVertexs,minDistance);
		for ( Vertex key : path.keySet()) {
			System.out.println(((MazeHex)key).getLabel());
		}
	}
}