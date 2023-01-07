package graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
		while ( !( processedVertexes.isInProcessedVertexes( endVertex ) ) ){
			if(graph.getSuccessors(pivotVertex) ==null) {
				break;
			}
			for (Vertex v : graph.getSuccessors(pivotVertex)) {
				if ( !( processedVertexes.contains(v) ) && 
						((minDistance.actuelMinDistance(pivotVertex) + 1) < minDistance.actuelMinDistance(v))
						) {
					minDistance.replaceMinDistance( minDistance.actuelMinDistance(pivotVertex) + 1 , v);
					path.path(v,pivotVertex);
			
					
				}
			}
			
			Collection<Integer> L = minDistance.values();
			List<Integer> list = new ArrayList<Integer>( L );
			Collections.sort(list);
			ArrayList<Vertex> VV = new ArrayList<Vertex>();
			for (int k :list) {
				for(Vertex nextVertex : minDistance.keySet()) {
					if ( minDistance.get(nextVertex).equals(k) && VV.contains(nextVertex)==false ) {
						VV.add(nextVertex);
					}
				}
			}
			for(Vertex nxtVertex : VV) {
				if (!processedVertexes.isInProcessedVertexes(nxtVertex)) {
					pivotVertex = nxtVertex;
					break;
				}
			}
			processedVertexes.unionPivot(pivotVertex);
			
		}
		return path;
	}
}
