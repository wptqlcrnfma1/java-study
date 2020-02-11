package socketTest02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
			
			byte[] bytes = null; //받을 데이터 바이트 배열 선언
			String message = null; //String으로 변환해서 저장할 변수 선언
			
			InputStream is = socket.getInputStream(); //클라이언트가 보낸 데이터를 얻을려고 인풋스트림 선언
			bytes = new byte[100]; //바이트 배열 생성
			int readByteCount = is.read(bytes); //클라이언트가 데이터를 보내기 전까지 blocking. 클라가 데이터보내면 bytes에 저장된다. 실제 읽은 byte수는 int 변수에 저장
			message = new String(bytes,0,readByteCount,"UTF-8"); // 읽은 바이트 0~ 읽은곳 까지 utf-8로 string 저장
			System.out.println("[데이터 받기 성공]" + message);
			
			//서버가 클라이언트로 데이터를 보내기
			OutputStream os = socket.getOutputStream(); //소캣으로부터 outputstream 얻어낸다
			message = "Hello Client"; //보낼메세지 임의 지정
			bytes = message.getBytes("UTF-8"); //메세지로부터 byte배열을 얻어낸다
			os.write(bytes); // bytes배열 보내기
			os.flush(); // flush 출력
			System.out.println("[데이터 보내기 성공]");
			
			//in , out stream 사용안하니까 닫아주고 클라연결도 필요없어서 socket도 닫는다
			is.close();
			os.close();
			socket.close(); //연결을 끊겠다.
			
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
