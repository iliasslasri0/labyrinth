package graph;

import java.util.HashSet;

public class ProcessedVertexesImpl extends HashSet<Vertex> implements ProcessedVertexes{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void unionPivot(Vertex V) {
		add(V);
	}

	@Override
	public boolean isInProcessedVertexes(Vertex V) {
		contains(V);
	}


}
