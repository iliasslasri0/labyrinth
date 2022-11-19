package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestPathsImpl extends HashMap<Vertex,Vertex> implements ShortestPaths{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Override
	public HashMap<Vertex, Vertex> path(HashMap<Vertex, Vertex> shortestPath, Vertex vertex2,
			Vertex vertex1) {
		shortestPath.put(vertex2, vertex1);
		return shortestPath;
	}
	
	/**
	 * 
	 */
	@Override
	public List<Vertex> getShortestPath(HashMap<Vertex, Vertex> path,Vertex departVertex) {
		List<Vertex> shortestPath = new ArrayList<>();
		shortestPath.add(departVertex);
		for ( Entry<Vertex, Vertex> connection : path.entrySet()) {
			shortestPath.add(connection.getValue());
		}
		return shortestPath;
	}
}