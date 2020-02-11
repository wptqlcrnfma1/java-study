package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

//읽고 출력하고 다시 대기상태 .. 다시대기 상태
public class TCPServer {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 5001;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		// 1. 서버소캣 생성
		try { //서버소켓에 대한 try
			serverSocket = new ServerSocket();
			
			//1.1 Time-wait 시간에 소켓에 포트번호 할당을 가능하게 하기 위해서
			serverSocket.setReuseAddress(true); // 서버에서는 필수 재할달이 가능해진다.
			
			// 2. 바인딩(Socket Address(IP Address + Port) Binding)
			serverSocket.bind(new InetSocketAddress(SERVER_IP, 23));

			// 3. accept
			// 서버는 계속 위에서 작동해야되고 끝나면 안되니까 컴파일 올리는 코드 돌면서 쓰레드 발생해야함
			Socket socket = serverSocket.accept(); // blocking , 연결요청 할떄까지 대기상태
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			//remoteSocket = 상대편의 소캣정보
			
			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();

			System.out.println("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			try { //서버소켓이 아닌 다른 socket 통신객체를 위한 try
				// 4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				while (true) {
					// 5. 데이터 읽기 > 무한루프로 감싸서 계속 읽게
					byte[] buffer = new byte[256];

					// 블락킹이 한번 된다 밑에 줄에서
					int readByteCount = is.read(buffer); // 버퍼에 읽는 수만큼 return 200바이트면 200 return, 2번쨰 블라킹

					if (readByteCount == -1) {
						// remote해서 client에서 읽었는데 -1이 return되면 정상종료하는 구문 확 끄면 exception 발생
						System.out.println("[Server]close by client");
						break;
					}

					// 아니면 읽은거
					String data = new String(buffer, 0, readByteCount, "UTF-8"); // 읽은 수만큼 UTF- 8로 인코딩
					System.out.println("[Server]received : " + data);

					// 6. 데이터쓰기
					os.write(data.getBytes("UTF-8")); // 텔넷 프로그램이 응답을 받으니까 출력된다.
				}
			} catch (SocketException e) {
				System.out.println("[Server] sudden closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
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

}
