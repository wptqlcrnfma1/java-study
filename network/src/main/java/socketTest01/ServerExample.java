package socketTest01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
	ServerSocket serverSocket = null; //서버소켓의 변수 선언
	
	try {
		serverSocket = new ServerSocket(); //서버소캣 객체 생성 예외발생때문 예외처리
		serverSocket.bind(new InetSocketAddress("localhost",5001)); //포트와 바인딩을 위해 현재pc에 localhost, 5001 포트 바인딩
		while(true) { //서버는 항상 클라이언트의 요청을 기다린다.
			System.out.println("[연결 기다림]");
			Socket socket = serverSocket.accept(); //클라이언트의 요청 수락하는 역할 BLOCKING이라고한다. 오기전까지 기다린다는 의미. 요청되면 통신용객체를 만들고 return.
			// 위 소캣 객체로 클라이언트와 정보를 얻고 주고받기 가능함
			
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			//getRemoteSocketAddress가 SocketAddress를 return하기 때문에 타입변환. 실질적으로 InetSocketAddress가 return 
			
			System.out.println("[연결 수락함]" + isa.getHostName()); //클라이언트 ip주소를 얻어옴(확인용)	
		
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	if(!serverSocket.isClosed()) { //서버소켓이 현재 닫혀있지 않으면 (실행중이면) 종료. 당장은 필요없지만 UI추가되면 버튼눌러서 서버종료위해
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//테스트를 위해 클라이언트 추가
	}
}
