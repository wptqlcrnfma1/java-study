package socketTest01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
//서버에 요청을 위해 소캣 생성
	public static void main(String[] args) {

		Socket socket = null;

		try {
			socket = new Socket();
			// 소캣 생성 이후 연결 요청해야함

			System.out.println("[연결 요청]");
			
			socket.connect(new InetSocketAddress("localhost", 5001));
			//connnet가 실행되면 5001번 포트의 서버에 연결요청
			
			System.out.println("[연결 성공]"); // 성공하면 실행됨
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
