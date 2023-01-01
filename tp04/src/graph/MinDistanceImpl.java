package graph;

import java.util.HashMap;

public class MinDistanceImpl extends HashMap<Vertex,Integer> implements MinDistance {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void replaceMinDistance(int d, Vertex V) {
		this.put(V, d);//We don't have a problem here because if the Vertex V
					// already exists in the HashMap, the value d will replace 
					// the previous value
	}

	@Override
	public int actuelMinDistance(Vertex V) {
		return this.get(V);
	}
}
