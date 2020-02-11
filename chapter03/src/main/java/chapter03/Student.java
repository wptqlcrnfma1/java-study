package chapter03;

public class Student extends Person {
	public Student() {
		//super(); 
		// 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면,
		// 자동으로 부모의 기본생성자를 호출하게 된다.
		// 자동으로 상속을 받은 자식앞에 super()가 들어 있는 것과 같다.[보이지 않아도 자동 생성]
		System.out.println("Student() called");
	}
}
