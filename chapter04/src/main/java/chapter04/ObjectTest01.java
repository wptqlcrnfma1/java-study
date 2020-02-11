package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		Class klass = p.getClass();			 //클래스 정보를 가지고 옴 (reflection)
		System.out.println(klass.getName()); 
		
		System.out.println(p.hashCode());    //reference value X
		   									 //address 		   X
											 //address 기반의 해싱값(int) 개체의 유일한 값, 예) 배열이나 긴 문자 같은 경우, 비교를 빠르게 하기 위함.
		
		System.out.println(p);
		System.out.println(p.toString()); 	 //println의 경우 객체가 그냥 들어오면 String값으로 출력 해줌.
											 //getClass() + "@" + hashCode()
	}
}
