package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class LocalHost {

	public static void main(String[] args) {

		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			byte[] adresses = inetAddress.getAddress();
			System.out.println(Arrays.toString(adresses));
			System.out.println("inet = " + inetAddress.getHostAddress());
			for(byte adress: adresses) {
				
				//System.out.println(adress); //음수가 나온다. 왜?? 2의보수에서 맨앞자리 부호가 그대로이기때문
				System.out.print(adress & 0x000000ff); // 부호비트 없애는거
			}
			
			System.out.println(hostname);
			System.out.println(hostAddress);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("에러");
		}
	}

}
