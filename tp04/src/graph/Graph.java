package graph;

import java.util.ArrayList;
import java.util.List;

public interface Graph {
	
	/**
	 * @return A list of all the boxes possible to pass through & the departure Hex & the arrival Hex
	 * 
	 */
	public List<Vertex> getAllVertexes();
	
	/**
	 * @return A list of the neighbors of a box(Hexagon)
	 */
	public List<Vertex> getSuccessors(Vertex vertex);
	
	
	public ArrayList<Vertex> succVertexNotProcce(Vertex V);
	
	
}
