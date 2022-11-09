import java.util.*;
package graph;

public class Dijkstra {
	private static final String BigInteger = ;

	public ShortestPaths dijkstra(Graph graph,Vertex startVertex,Vertex endVertex,ProcessedVertexes processedVertexes, MinDistance minDistance,Distance distance) {
		ProcessedVertexes processedvertexes = new ProcessedVertexes;
		unionPivot(Vertex startVertex);
		replaceMinDistance(0,startVertex);
		
		for (Vertex v : graph) {
			replaceMinDistance(Float.POSITIVE_INFINITY,v);
		
		}
		while (!( isInProcessedVertexes(endVertex))){
			for (Vertex v:succVertexNotProcce(pivotVertex)) {
				if (minDistance(pivotVertex) + distance(pivotVertex, v) < minDistance(v)) {
					replaceMinDistance(minDistance(pivotVertex) + distance(pivotVertex, v), v);
					previous(v)=pivot;
				}
			}
		}
	}

	
	
}
