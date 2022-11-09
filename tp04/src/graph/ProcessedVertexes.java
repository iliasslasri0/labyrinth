package graph;

import java.util.ArrayList;
public interface ProcessedVertexes {
		// cette méthode ajoute le pivot 
		// dés qu'il soit traité
		// et le sommet de start
		public void unionPivot(Vertex V);
		
		//Cette méthode teste si 
		// un Vertex est dans les Vertex traités ou non.
		public boolean isInProcessedVertexes(Vertex V);
		
		// Cette méthode retourne les successeures de pivotVertex
		// qui ne sont pas encore dans processedVertexes
		public ArrayList<Vertex> succVertexNotProcce(Vertex V);
		
}
