package graph;

import java.util.HashSet;

public class ProcessedVertexesImpl extends HashSet<Vertex> implements ProcessedVertexes{
	private static final long serialVersionUID = 1L;
	
	/**
	 * this method add the vertex V to the list of processed vertexes
	 */
	@Override
	public void unionPivot(final Vertex V) {
		this.add(V);
	}
	
	
	/**
	 * this method examine the exictence of the vertex V in the processed vertexes
	 * @return boolean 
	 */
	@Override
	public boolean isInProcessedVertexes(final Vertex V) {
		return this.contains(V);
	}
}