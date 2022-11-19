package graph;

public class Dijkstra {

	public ShortestPathsImpl dijkstra(Graph graph,
			Vertex startVertex,
			Vertex endVertex,
			ProcessedVertexes processedVertexes,
			MinDistance minDistance,
			Distance distance) {

		processedVertexes.unionPivot(startVertex);
		minDistance.replaceMinDistance(0,startVertex);
		Vertex pivotVertex =  startVertex;
		ShortestPathsImpl path = new ShortestPathsImpl();
		
		for (Vertex v : graph.getAllVertexes()) {
			minDistance.replaceMinDistance(Integer.MAX_VALUE,v);
		}
		while ( processedVertexes.isInProcessedVertexes(endVertex)){
			for (Vertex v: graph.succVertexNotProcce(pivotVertex)) {
				if (minDistance.actuelMinDistance(pivotVertex) + distance.distance(pivotVertex, v) < minDistance.actuelMinDistance(v)) {
					minDistance.replaceMinDistance( minDistance.actuelMinDistance(pivotVertex) + distance.distance(pivotVertex, v), v);
					path.path(path,pivotVertex,v);
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
