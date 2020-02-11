package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final int PORT = 5001;
	private static final String CLINET_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. scanner 생성(표준입력, 키보드 연결)
			scanner = new Scanner(System.in);
			
			// 2. 소캣 생성
			socket = new Socket();
			
			

			// 3. 서버 연결
			socket.connect(new InetSocketAddress(CLINET_IP, PORT));
			log("connected");

			// 4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true); //명시적으로 flush를 쓰지 않겠다.
			
			while (true) {
				// 5. 키보드 입력받기
				System.out.print(">>");
				String line = scanner.nextLine();

				if ("quit".equals(line)) {
					break;
				}
				// 6. 데이터 쓰기
				pw.println(line);

				// 7. 데이터 읽기
				String data = br.readLine();
				if (data == null) {
					log("closed by server");
					break;
				}

				System.out.println("<<" + data);
			}
		} catch (IOException e) {

		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}

				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {

			}
		}
	}
	public static void log(String log) {
		System.out.println("[Client]" + log);
	}

}
