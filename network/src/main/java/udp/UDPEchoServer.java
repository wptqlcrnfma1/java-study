package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer { //포트가 같아도 상관없다. TCP로 8000번 열어도 UDP 8000번 에러안난다. 같은 프로토콜이면 에러남
	private static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		//주소는 패킷안에 들어있다. 편지같은 느낌 데이터를 봉투에 넣고
		DatagramSocket socket = null;
		try {
			//1. 소캣생성
			socket = new DatagramSocket(PORT);
			
			while(true) {
			//2. 데이터 수신 : 데이터 수신을 위해 , (바이트버퍼, 사이즈)
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePacket); // blocking
			
			byte[] data = receivePacket.getData();  //데이터 가져오기
			int length = receivePacket.getLength();
			//인코딩
			String message = new String(data, 0, length, "UTF-8");
			
			System.out.println("[server] received : " + message);
			
			//3. 데이터 송신 :  받은걸 다시 보내야함
			
			byte[] sendData = message.getBytes("UTF-8");
			//(데이터, 길이, 받는사람 주소 )
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
			socket.send(sendPacket);
			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) { 
			e.printStackTrace();
		}
		
		finally {
			if(socket !=null && !socket.isClosed()) {
				socket.close();
			}
		}
		

	}

}
