import java.util.HashMap;
import java.util.HashSet;

import graph.Distance;
import graph.DistanceImpl;
import graph.Graph;
import graph.Dijkstra;
import graph.MinDistance;
import graph.ProcessedVertexes;
import graph.Vertex;
import maze.ArrivalHex;
import maze.DepartureHex;
import maze.Maze;
import maze.MazeHex;

public class MainTest {

	public static void main(String[] args) throws Exception {
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("data\\labyrinthe.maze");
		MazeHex d= new DepartureHex(maze,0,0);
		MazeHex a= new ArrivalHex(maze,0,0);
		HashSet<Vertex> processedVertexes = new HashSet<>();
		HashMap<Vertex,Integer> minDistance = new HashMap<Vertex,Integer>();
		DistanceImpl distance = new DistanceImpl(1);
		
		return Dijkstra(maze,d,a,processedVertexes,minDistance,distance);
	}
}