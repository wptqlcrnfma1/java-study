package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
		System.out.println(s1 == s2);  //false
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1.hashCode() + ":" + s2.hashCode());  //true
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2)); //주소기반의 해쉬코드 값(flase)
		
		System.out.println("--------------------------------------");
		
		String s3 = "ABC";
		String s4 = "ABC";
		System.out.println(s3 == s4); //true
		System.out.println(s3.equals(s4)); //true
		System.out.println(s3.hashCode() + ":" + s4.hashCode());  //true
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));  //true
		
		//즉, 프로그램을 재사용 할 경우 String은 new를 선언하지 않고 각각 선언하는게 비교할 땐 제약조건이 덜 하다
		//String의 경우 새로운 값을 생성 시킴 /// 예
	}

}
