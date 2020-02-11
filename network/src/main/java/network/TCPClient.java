package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class TCPClient {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 23;
	
	public static void main(String[] args) {
		Socket socket = null;
	//2. 서버 연결	
		try {
			// 1.소켓 생성
			 socket = new Socket();
			
			//1-1 소캣 버퍼 사이즈 확인 > 속도와는 상관없다.text위주라면
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBuufferSize = socket.getSendBufferSize();
			System.out.println(receiveBufferSize + ":" + sendBuufferSize );
			
			//1-2 소캣 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024*8);
			socket.setSendBufferSize(1024*10);
			System.out.println(receiveBufferSize + ":" + sendBuufferSize );
			
			
			//1-3 Nagle 알고리즘 off
			socket.setTcpNoDelay(true);
			
			//1-4 timeout 1초있다가 데이터안오면 exception 발생
			socket.setSoTimeout(1000);
			
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT)); //상대편임 accept랑 짝
			System.out.println("[client]connected");
			
			//3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
					
			//4. 쓰기(클라에서)
			String data = "hello world";
			os.write(data.getBytes("UTF-8"));
			
			
			try {
				Thread.sleep(2000); //time out 보려고 넣은 소스 2초 쉬게
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//5. 읽기(서버에서)
			byte[] buffer = new byte[256];

			//블락킹이 한번 된다 밑에 줄에서
			int readByteCount = is.read(buffer); // 버퍼에 읽는 수만큼 return 200바이트면 200 return

			if (readByteCount == -1) { // 서버가 끊은거
				System.out.println("[client]close by SERVER");
				return;
			}

			// 아니면 읽은거
			data = new String(buffer, 0, readByteCount, "UTF-8"); // 읽은 수만큼 UTF- 8로 인코딩 3바이트씩 짜름 한글기준
			System.out.println("[client]received : " + data);
			

			
		} catch(SocketTimeoutException e) {
			System.out.println("[Client Time out]");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally { //정상적으로 안하면 소켓exception 나니까 finally 선언
			try {
				if(socket != null && socket.isClosed() == false) //2번 닫으면 에러나니까
				socket.close(); //inputStream 닫으면 얘도 닫혀서 위에 조건
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
