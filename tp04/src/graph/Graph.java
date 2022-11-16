package graph;

import java.util.ArrayList;
import java.util.List;

public interface Graph {
	public List<Vertex> getAllVertexes();
	
	public List<Vertex> getSuccessors(Vertex vertex);
	
	public ArrayList<Vertex> succVertexNotProcce(Vertex V);
	
	
}
