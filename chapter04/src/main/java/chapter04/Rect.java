package chapter04;

public class Rect {
	private int width;
	private int hight;
	
	public Rect(int width, int hight) {
		this.width = width;
		this.hight = hight;
	}

	@Override
	public String toString() {
		return "Rect[width=" + width + ",hight=" + hight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hight;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		if (hight != other.hight)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
}
