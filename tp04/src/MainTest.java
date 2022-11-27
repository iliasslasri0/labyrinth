import graph.Dijkstra;
import graph.MinDistanceImpl;
import graph.ProcessedVertexesImpl;
import maze.ArrivalHex;
import maze.DepartureHex;
import maze.Maze;
import maze.MazeHex;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		Dijkstra dij = new Dijkstra();
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("data\\labyrinthe.maze");
		MazeHex d= new DepartureHex(maze,0,0);
		MazeHex a= new ArrivalHex(maze,0,0);
		ProcessedVertexesImpl processedVertexs = new ProcessedVertexesImpl();
		MinDistanceImpl minDistance = new MinDistanceImpl();
		
		dij.dijkstra(maze,d,a,processedVertexs,minDistance);
	}
}