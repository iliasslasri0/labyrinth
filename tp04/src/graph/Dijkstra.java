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
			minDistance.replaceMinDistance(2147483640,v);
			
		}
		
		minDistance.replaceMinDistance(0,startVertex);
		for ( Vertex v1 : graph.getAllVertexes() ){
			for (Vertex v: graph.getSuccessors(pivotVertex)) {
				
				
				if (!processedVertexes.contains(v) && ((minDistance.actuelMinDistance(pivotVertex) + 1) < minDistance.actuelMinDistance(v))) {
					minDistance.replaceMinDistance( minDistance.actuelMinDistance(pivotVertex) + 1 , v);
					path.path(pivotVertex,v);
					System.out.println(((MazeHex)v).getX() );
					System.out.println(((MazeHex)v).getY() );
					System.out.println("O ici ohhhh");
					
				}
			}
			
			
			int m = 2147483647 ;
			Vertex pV = null;
			for (Vertex v2 : graph.getAllVertexes() ) {
				if ( minDistance.actuelMinDistance(v2) < m && !processedVertexes.isInProcessedVertexes(v2) ) {
					pV = v2;
					m = minDistance.actuelMinDistance(v2);
					System.out.println(((MazeHex)pV).getLabel() );
					
				}
			}
			pivotVertex = pV;
			processedVertexes.unionPivot(pivotVertex);
		}
		return path;
	}
}
