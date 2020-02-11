package ThreadEx01;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabetThread();
		
		//Thread thread3 = new UppercaseAlphabetRunnalbeimpl(); //안되노 밑에처럼 구현
		Thread thread3 = new Thread(new UppercaseAlphabetRunnalbeimpl());
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
