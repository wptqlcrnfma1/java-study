package Exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10-a;  // b = 10-a;면 예외 발생
		
		System.out.println("some codes0");
		try {
			System.out.println("some codes1");
			int result = (1+2+3) / b;
			System.out.println("some codes2");
		}
		catch(ArithmeticException ex) {
			//1. 사용자에게 사과
			System.out.println("정말 죄송합니다...");
			//2. 로그 남기기(파일, DB 등)
			System.out.println(ex);
			//3. 정상종료
			return;
		}
		finally {
			System.out.println("some codes4");
			//finally는 정상적으로 실행되어도 실행되고, 비정상적인 실행이어도 실행된다.
		}
		System.out.println("some codes5");
	}

}
