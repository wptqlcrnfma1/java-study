package ThreadEx01;

public class TheradEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=0;i<=10;i++) {
//			System.out.print(i );
//		}
		
		Thread digitalThread = new DigitalThread();
		digitalThread.start();
		//인터럽트 걸리는게 코드마다 다른데 for문같은건 다 돌고 출력
		//싱크 맞추려고 thread 잠깐 재우면 된다. 1초간격으로 재우고 깨우고 이런식.
		
		for(char c = 'a';c<='z';c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);// 1초 재우는거
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

}
