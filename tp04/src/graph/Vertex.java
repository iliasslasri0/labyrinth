package graph;

public interface Vertex {
	
	// Cette méthode affecte à un sommet V une distance d
	public void minDistance(Vertex V,int d);
	
	public String getLabel();
	
	
	// Cette méthode renvoie la distance au sommet V
	public int minDistance(Vertex V);
	
	// Cette méthode renvoie la distance de pivot à son successeur
	public int distance(Vertex pivot,Vertex succ);
	
}
