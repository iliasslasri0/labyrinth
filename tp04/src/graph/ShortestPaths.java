package graph;

import java.util.HashMap;
import java.util.List;

public interface ShortestPaths {
	/**
	 * 
	 * @param shortestPath
	 * @param vertex2
	 * @param vertex1
	 * @return
	 */
	public HashMap<Vertex, Vertex> path(HashMap<Vertex, Vertex> shortestPath,
													Vertex vertex2,
													Vertex vertex1);
	/**
	 * 
	 * @param path
	 * @param departVertex
	 * @return
	 */
	public List<Vertex> getShortestPath(HashMap<Vertex, Vertex> path, Vertex departVertex);
}
