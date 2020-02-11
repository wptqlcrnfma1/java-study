package ThreadEx01;

public class DigitalThread extends Thread {

	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.print(i );
			try {
				Thread.sleep(1000);// 1초 재우는거
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

}
