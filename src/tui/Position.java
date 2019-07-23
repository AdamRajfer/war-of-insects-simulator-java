package tui;

public class Position implements Cloneable {
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private int x;
	private int y;
	
	protected void addToPosition(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	protected void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
