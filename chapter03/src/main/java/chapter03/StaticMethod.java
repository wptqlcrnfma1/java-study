package chapter03;

public class StaticMethod {

	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		//같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	void f3() {
		f2();
	}
	static void f4() {
		StaticMethod.s1();
		s1();
	}
	
	static void s1() {
		//System.out.println(n); 
		// 오류 : static 메소드에서 인스턴스 변수 접근은 안된다.
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		//같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	static void s3() {
		//f1();
		//오류 : static 메소드에서 인스턴스 메소드 접근은 안된다.
	}
	static void s4() {
		StaticMethod.s1();
		s1();
		//같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
	}
}
