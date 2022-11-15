package graph;
import java.util.*;

public class Dijkstra {

	public ShortestPaths dijkstra(Graph graph,
			Vertex startVertex,
			Vertex endVertex,
			ProcessedVertexes processedVertexes,
			MinDistance minDistance,
			Distance distance) {
		
		ProcessedVertexes processedvertexes = new ProcessedVertexes;
		unionPivot(Vertex startVertex);
		replaceMinDistance(0,startVertex);
		
		for (Vertex v : graph) {
			replaceMinDistance(Float.POSITIVE_INFINITY,v);
		}
		while (!( isInProcessedVertexes(endVertex))){
			for (Vertex v:succVertexNotProcce(pivotVertex)) {
				if (actuelMinDistance(pivotVertex) + distance(pivotVertex, v) < actuelMinDistance(v)) {
					replaceMinDistance(minDistance(pivotVertex) + distance(pivotVertex, v), v);
					previous(v)=pivot;
					
				}
			
			for (Vertex v : succVertexNotProcce(pivotVertex) ;float i= Float.POSITIVE_INFINITY) {
				if (actuelMinDistance(v) <=   i) {
					i = actuelMimnDistance(v);
					pivotVertex = v;
					
					
				}
				unionPivot(v);
				
			}
			}
		}
	}

	
	
}
