package network;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
private static final int PORT = 23;
private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		List<Writer> listWriters = new ArrayList<Writer>();

		ServerSocket serverSocket = null;
		// 1. 서버소캣 생성
		try { //서버소켓에 대한 try
			serverSocket = new ServerSocket();
			
			//1-1. 버퍼사이즈 확인
			
			
			
			// 2. 바인딩(Socket Address(IP Address + Port) Binding)
			serverSocket.bind(new InetSocketAddress("localhost", PORT));
			log("Server Starts... [port:" + PORT + "]");

			// 3. accept
			// 서버는 계속 위에서 작동해야되고 끝나면 안되니까 컴파일 올리는 코드 돌면서 쓰레드 발생해야함
			while(true) {	
				Socket socket = serverSocket.accept(); // blocking , 연결요청 할떄까지 대기상태 한 쓰레드가 작동하고 있음
				new EchoServerReceiveThread(socket).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket!= null && !serverSocket.isClosed())
				serverSocket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void log(String log) {
		System.out.println("[Server]#"+ Thread.currentThread().getId() + log);
	}
}
