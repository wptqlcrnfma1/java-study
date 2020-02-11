package paint;

public class PointApp {

	public static void main(String[] args) {
		Point poin1 = new Point(2,5);
		draw(poin1);
		//drawPoint(poin1);
		
		Point point2 = new Point(10, 50);
		//drawPoint(point2);
		draw(point2);
		//point2.show(false);
		
		ColorPoint point3 = new ColorPoint(50, 100, "red");
		//drawPoint(point3);
		draw(point3);
		point3.show(false);
		point3.show(true);
		
		Rect rect = new Rect();
		//drowRect(rect);
		//drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
		//drowRect(triangle);
		//drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicTest("hellow"));
		
		//Instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		//System.out.println(circle instanceof Rect);
		//오류 : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
		//오류 : 부모는 물어 볼 수 있지만 옆에 있는 형제 클래스는 물어 볼 수 없다.
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		//Interface 는 hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable); //Runnable API에 있는 것(선언한게 아님)
		}

	//public static void drawPoint(Point point) {
	//	point.draw();
	//}
	//public static void drawShape(Shape shape) {
	//	shape.draw();
	//}
	public static void draw(Drawable d) {
		d.draw();
	}
	/*public static void drowRect(Rect rect) {
		rect.draw();
	}
	public static void drowRect(Triangle triangle) {
		triangle.draw();
	}*/
}
