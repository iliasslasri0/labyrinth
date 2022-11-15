package graph;

import java.util.ArrayList;

public interface ShortestPaths {
	// retourner le sommet à traiter en suite
	public Vertex selectionVertex(Vertex pivotVertex);
	
	// Cette méthode retourne les successeures de pivotVertex
	// qui ne sont pas encore dans processedVertexes
	public ArrayList<Vertex> succVertexNotProcce(Vertex V);
}
