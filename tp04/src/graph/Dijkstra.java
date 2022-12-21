package graph;
import maze.MazeHex;

public class Dijkstra {

	public ShortestPathsImpl dijkstra(Graph graph,
			Vertex startVertex,
			Vertex endVertex,
			ProcessedVertexesImpl processedVertexes,
			MinDistance minDistance) {

		processedVertexes.unionPivot(startVertex);
		minDistance.replaceMinDistance(0,startVertex);
		Vertex pivotVertex =  startVertex;
		ShortestPathsImpl path = new ShortestPathsImpl();
		
		for (Vertex v : graph.getAllVertexes()) {
			minDistance.replaceMinDistance(Integer.MAX_VALUE,v);
		}
		System.out.println(Integer.MAX_VALUE);
	
		
		while ( !( processedVertexes.isInProcessedVertexes(endVertex)) ){
			System.out.println("f1");
			for (Vertex v: graph.succVertexNotProcce(pivotVertex)) {
				if (minDistance.actuelMinDistance(pivotVertex) + 1 < minDistance.actuelMinDistance(v)) {
					minDistance.replaceMinDistance( minDistance.actuelMinDistance(pivotVertex) + 1 , v);
					path.path(pivotVertex,v);
					
				}
			}
			
			
			int m = Integer.MAX_VALUE ;
			
			for (Vertex nextVertex: graph.succVertexNotProcce(pivotVertex)) {
				if ( minDistance.actuelMinDistance(nextVertex) < m) {
					System.out.println( "here");
					pivotVertex = nextVertex;
					m = minDistance.actuelMinDistance(nextVertex);
					System.out.println( m);
					System.out.println(((MazeHex)pivotVertex).getX());
				}
			}
			System.out.println(((MazeHex)pivotVertex).getY());
			processedVertexes.unionPivot(pivotVertex);
		}
		System.out.println("ici");
		return path;
	}

}
