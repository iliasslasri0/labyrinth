package graph;
public interface MinDistance {
	
	//changer la minDistance d'un sommet V par la distance d
	public void replaceMinDistance(final int d,final Vertex V);
	
	//retourner la minDistance d'un sommet V
	public int actuelMinDistance(final Vertex V);
	
}
