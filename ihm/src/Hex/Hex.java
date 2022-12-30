package Hex;

public class Hex {
	private int  x;
	private int y;
	private String Label;
	
	public Hex(int x, int y, String Label) {
		setX(x);
		setX(y);
		setLabel(Label);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	
}
