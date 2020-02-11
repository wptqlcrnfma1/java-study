package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPTimeClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5001;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		Scanner scanner = null;
		DatagramSocket socket = null;

		try {
			// 1. 스캐너 생성(표준입력, 키보드 입력)
			scanner = new Scanner(System.in);

			// 2. socket생성
			socket = new DatagramSocket();

			while (true) {
				// 3. 키보드 입력받기
				System.out.print(">>");
				String line = scanner.nextLine();

				if ("quit".equals(line)) {
					System.out.println("종료");
					break;
				}
				// 4. 데이터 쓰기
				
				byte[] sendData = line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						new InetSocketAddress(SERVER_IP, SERVER_PORT));
				socket.send(sendPacket);

				// 5. 데이터 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); // blocking
				
				
				byte[] data = receivePacket.getData(); // 데이터 가져오기
				int length = receivePacket.getLength();
				// 인코딩
				String message = new String(data, 0, length, "UTF-8");

				System.out.println("<<" + message);

			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();

				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			}
		}
	}
}