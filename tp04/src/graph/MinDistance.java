package graph;
public interface MinDistance {
	//changer la minDistance d'un sommet V par la distance d
	public void replaceMinDistance(float d,Vertex V);
	
	//retourner la minDistance d'un sommet V
	public int actuelMinDistance(Vertex V);
}
