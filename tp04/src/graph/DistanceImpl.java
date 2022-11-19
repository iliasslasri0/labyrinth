package graph;

public class DistanceImpl implements Distance{
	int d;
	public DistanceImpl(int in){
		this.d=in;
	}
	@Override
	public int distance(Vertex V, Vertex V2) {
		return d;
	}

}
