package paint;

public class Circle extends Shape {
	private int x;
	private int r;
	private int radius;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	@Override
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}

}
