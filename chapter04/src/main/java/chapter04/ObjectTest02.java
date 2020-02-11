package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		// == : 두 객체의 동일성 비교
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);

		//equal : 두 객체의 동질성 비교(내용비교)
		//		  Object의 기본 구현은 동일성 비교와 같다.
		//        비교하려면 오버라이드를 해야 함. (근데 equals(p2)이것만 오버라이드 하면 안되고 p1도 같이 오버라이드 되어야 함.)
		//        오버라이드 할 경우 HashCode먼저 오버라이드 해주어야 함
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		System.out.println(p1.equals(p3));
	}

}
