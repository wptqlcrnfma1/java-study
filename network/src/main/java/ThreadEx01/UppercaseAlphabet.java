package ThreadEx01;

public class UppercaseAlphabet {
	public void print() { //얘를 쓰레드에 태우고 싶다.
		//얘를 상속받고 runnable 인터페이스 사용
		for(char c='A';c<='Z';c++) {
			System.out.print(c);
		}
	}
}
