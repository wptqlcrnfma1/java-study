package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);
		
		swap(a,b);
		
		System.out.println(a + ":" + b);
	}

	public static void swap(int m, int n)
	{
		int temp = m;
		m = n;
		m = temp;
	}//메소드가 끝남과 동시에 안에 있던 변수들은 전부 날라감  --> 그렇기에 위에 선언한 a,b의 값이 변하지 않음

}
