package graph;

public interface ProcessedVertexes {
		/* cette méthode ajoute le pivot 
		dés qu'il soit traité
		 et le sommet de start */
		public void unionPivot(final Vertex V);
		
		/* Cette méthode teste si 
		 un Vertex est dans les Vertex traités ou non. */
		public boolean isInProcessedVertexes(final Vertex V);	
}
