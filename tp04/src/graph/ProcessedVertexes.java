package graph;
public interface ProcessedVertexes {
		// cette méthode servera à ajouter le pivot 
		// dés qu'il soit traité
		// et le sommet de start
		public void unionPivot(Vertex V);
		
		//Cette méthode servera à tester si 
		// un Vertex est dans les Vertex traités ou non.
		public boolean isInProcessedVertexes(Vertex V);
}
