package graph;

import java.util.HashMap;
import java.util.List;

public interface ShortestPaths {
	/**
	 * 
	 * @param shortestPath
	 * @param vertex2
	 * @param vertex1
	 */
	public void path(final Vertex vertex2,
										final Vertex vertex1);
	/**
	 * 
	 * @param path
	 * @param departVertex
	 * @return
	 */
	public List<Vertex> getShortestPath(final Vertex V);
}
