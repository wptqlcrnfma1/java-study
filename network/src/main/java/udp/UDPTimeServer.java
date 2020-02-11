package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	private static final int PORT = 5001;
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
			
			System.out.println("서버가 열렸습니다.");
			byte[] data = receivePacket.getData();  //데이터 가져오기
			int length = receivePacket.getLength();
			//인코딩
			String message = new String(data, 0, length, "UTF-8");
			
			SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss a" );
			String timeMessage = format.format( new Date() );

			System.out.println("[server] received : " + message);
			
			//3. 데이터 송신 :  받은걸 다시 보내야함
			if(" ".equals(message)) {
				byte[] sendTime = timeMessage.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendTime, sendTime.length, receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
			}
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
