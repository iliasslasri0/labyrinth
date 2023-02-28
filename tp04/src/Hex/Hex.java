package Hex;



public class Hex {
	private int row;
	private int coulum;
	private boolean isInPath;
	private boolean isWall;
	
	public Hex(int x,int y, boolean b, boolean c) {
		this.row = y;
		this.coulum = x;
		isWall = b;
		isInPath = c;
	}

	public void setIsInPath(boolean bool) {
		isInPath =bool;
	}
	
	public void setIsWall(boolean bool) {
		isWall = bool;
	}

	public boolean isWall() {
		return isWall;
	}

	public boolean isInPath() {
		return isInPath;
	}

	public int getRow() {
		return row;
	}

	public int getCoulum() {
		return coulum;
	}
}
