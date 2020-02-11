package chapter03;

public class SwapTest03 {

	public static void main(String[] args) {
		Vlaue a = new Vlaue();
		a.val = 10;
		Vlaue b = new Vlaue();
		b.val = 20;
		
		System.out.println(a.val + ":" + b.val);
		swap(a,b);
		System.out.println(a.val + ":" + b.val);
	}
	public static void swap(Vlaue n, Vlaue m)
	{
		int temp = m.val;
		m.val = n.val;
		n.val = temp;
	}

}
