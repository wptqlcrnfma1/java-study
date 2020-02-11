package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		// remoteSocket = 상대편의 소캣정보

		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();

		log("Server connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try { // 서버소켓이 아닌 다른 socket 통신객체를 위한 try
				// 4. IOStream 받아오기
				// *추가작업* //

			// InputStreamReader isr = new
			// InputStreamReader(socket.getInputStream(),"UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // 명시적으로 flush를 쓰지 않겠다.
																												
			while (true) {
				// 5. 데이터 읽기 > 무한루프로 감싸서 계속 읽게
				String data = br.readLine();
				// 블락킹이 한번 된다 밑에 줄에서

				if (data == null) {
					// remote해서 client에서 읽었는데 -1이 return되면 정상종료하는 구문 확 끄면 exception 발생
					log("close by client");
					break;
				}
				// 아니면 읽은거
				log("received : " + data);

				// 6. 데이터쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			log("suddenly closed by client");
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

	}
	
	public static void log(String log) {
		System.out.println("[Server#]"+ Thread.currentThread().getId() + log);
	}

}
