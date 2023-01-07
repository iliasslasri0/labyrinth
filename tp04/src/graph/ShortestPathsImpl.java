package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


public class ShortestPathsImpl extends HashMap<Vertex,Vertex> implements ShortestPaths{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void path(Vertex vertex1,Vertex vertex2) {
		this.put(vertex1, vertex2);
	}

	@Override
	public ArrayList<Vertex> getShortestPath(Vertex endVertex) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		Vertex v=endVertex;
		while (v != null) {
			path.add(v);
			v = this.get(v);
		}
		return path;
		
	}
}