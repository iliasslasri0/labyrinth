package Hex;



public class Hex {
	private int row;
	private int coulum;
	private String Label;
	
	public Hex(int x,int y, String Label) {
		this.row = y;
		this.coulum=x;
		this.Label = Label;
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

	public String getLabel() {
		// TODO Auto-generated method stub
		return Label;
	}

}
