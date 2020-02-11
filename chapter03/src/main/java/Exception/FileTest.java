package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {

	public static void main(String[] args) {
		//컴파일 자체가 안됨 -> 즉, try,catch를 필수적으로 써라는 말
		InputStream is = null;
		try {
			is = new FileInputStream("./hello.txt");
			int data = is.read();
			System.out.println(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}catch (IOException e) {
			e.printStackTrace();
			return;
		}
		finally {
			// finally목적 : 자원정리
			try {
				if(is!=null) {
					is.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
