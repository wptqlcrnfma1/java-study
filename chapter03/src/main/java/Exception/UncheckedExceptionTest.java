package Exception;

public class UncheckedExceptionTest {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		// 이런건 예외처리가 아니라 오류 // i < a.length
		for(int i = 0; i <= a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
