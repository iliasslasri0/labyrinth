package graph;

import java.util.HashMap;

public class MinDistanceImpl extends HashMap<Vertex,Integer> implements MinDistance {

	
	@Override
	public void replaceMinDistance(final int d,final Vertex V) {
		this.put(V, d);//We don't have a problem here because if the Vertex V
					// already exists in the HashMap, the value d will replace 
					// the previous value
	}

	@Override
	public int actuelMinDistance(final Vertex V) {
		return this.get(V);
	}
}
