package graph;
import maze.MazeHex;

public class Dijkstra {

	public ShortestPathsImpl dijkstra(Graph graph,
			Vertex startVertex,
			Vertex endVertex) {
		
		MinDistanceImpl minDistance = new MinDistanceImpl();
		ProcessedVertexesImpl processedVertexes = new ProcessedVertexesImpl();
		
		processedVertexes.unionPivot(startVertex);
		Vertex pivotVertex =  startVertex;
		
		ShortestPathsImpl path = new ShortestPathsImpl();
		
		for ( Vertex v : graph.getAllVertexes() ) {
			minDistance.replaceMinDistance(Integer.MAX_VALUE,v);
		}
		
		minDistance.replaceMinDistance(0,startVertex);
		while ( !( processedVertexes.isInProcessedVertexes(endVertex)) ){
			
			for (Vertex v : graph.getSuccessors(pivotVertex)) {
				
				
				if ( !(processedVertexes.contains(v)) && 
						((minDistance.actuelMinDistance(pivotVertex) + 1) < minDistance.actuelMinDistance(v))
						) {
					minDistance.replaceMinDistance( minDistance.actuelMinDistance(pivotVertex) + 1 , v);
					path.path(pivotVertex,v);
			
					
				}
			}
			
			
			int m = Integer.MAX_VALUE ;
			Vertex pV = pivotVertex;
			for (Vertex v2 : graph.getAllVertexes() ) {
				if ( (minDistance.actuelMinDistance(v2) < m) && !processedVertexes.isInProcessedVertexes(v2) ) {
					pV = v2;
					m = minDistance.actuelMinDistance(v2);
					
				}
			}
			pivotVertex = pV;
			processedVertexes.unionPivot(pivotVertex);
		}
		return path;
	}
}
