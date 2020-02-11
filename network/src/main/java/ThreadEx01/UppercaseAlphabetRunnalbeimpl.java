package ThreadEx01;

public class UppercaseAlphabetRunnalbeimpl extends UppercaseAlphabet implements Runnable {
//extends 없이 여기 for문 돌려도 되는데 일단 실습
	@Override
	public void run() {
		print();

	}

}
