package Hex;



public class Hex {
	private int row;
	private int coulum;
	private String Label;
	
	public Hex(int x,int y) {
		this.row = y;
		this.coulum=x;
	}
	
	public boolean isWall() {
		if(Label=="E") {
			return true;
		}
		return false;
	}
	public void setLabel(String lf) {
		this.Label = lf;
	}

}
