package graph;

import java.util.ArrayList;

public class Dijkstra {

	public ArrayList<Vertex> dijkstra(Graph graph,
			Vertex startVertex,
			Vertex endVertex,
			ProcessedVertexes processedVertexes,
			MinDistance minDistance,
			Distance distance) {

		processedVertexes.unionPivot(startVertex);
		minDistance.replaceMinDistance(0,startVertex);
		Vertex pivotVertex =  startVertex;
		
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		path.add(startVertex);
		
		for (Vertex v : graph.getAllVertexes()) {
			minDistance.replaceMinDistance(Float.POSITIVE_INFINITY,v);
		}
		while ( processedVertexes.isInProcessedVertexes(endVertex)){
			for (Vertex v: graph.succVertexNotProcce(pivotVertex)) {
				if (minDistance.actuelMinDistance(pivotVertex) + minDistance.getWeight(pivotVertex, v) < minDistance.actuelMinDistance(v)) {
					minDistance.replaceMinDistance( minDistance.actuelMinDistance(pivotVertex) + minDistance.getWeight(pivotVertex, v), v);
					path.add(v);
				}
			int m = minDistance.actuelMinDistance(graph.succVertexNotProcce(pivotVertex).get(0));
			pivotVertex = graph.succVertexNotProcce(pivotVertex).get(0) ;
			for (Vertex nextVertex: graph.succVertexNotProcce(pivotVertex)) {
				if (minDistance.actuelMinDistance(nextVertex) < m) {
					pivotVertex = nextVertex;
					m = minDistance.actuelMinDistance(nextVertex);
				}
				}
			processedVertexes.unionPivot(v);
			}
		}
		return path;
	}

}
