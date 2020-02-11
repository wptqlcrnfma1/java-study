package paint;

public class ColorPoint extends Point {

	private String color;
	
	public ColorPoint(int x, int y, String color) {
		super(x,y); // get과 set 사용 안해도 됨
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public String setColor(String color) {
		return this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ",y=" + getY() + ",color=" + color + "]을 그렸습니다");
	}
	
}
