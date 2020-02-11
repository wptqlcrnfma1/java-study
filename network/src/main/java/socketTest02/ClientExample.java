package socketTest02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
			
			//서버로 데이터 보내는 코드
			byte[] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream();
			message = "Hello Server"; 
			//메세지로부터 바이트배열을 얻는다.
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 보내기 성공]");
			
			//서버에서 보낸 데이터를 받는다.
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes,0,readByteCount,"UTF-8");
			System.out.println("[데이터 받기 성공]" + message);
			
			//필요없으니 닫는다.
			is.close();
			os.close();
			//소캣은 밑에 if에서 닫히니까 굳이 안넣음.
			
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
