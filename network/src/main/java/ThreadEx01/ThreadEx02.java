package ThreadEx01;

public class ThreadEx02 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabetThread();
		
		
		thread1.start();
		thread2.start();
	}

}
