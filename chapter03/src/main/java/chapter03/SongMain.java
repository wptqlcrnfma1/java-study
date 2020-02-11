package chapter03;


public class SongMain {
	public static void main(String[] args) {
		Song song = new Song();
		song.setTitle("좋은날");
		song.setArtist("아이유");
		song.setAlbum("real");
		song.setTrack(3);
		song.setYear(2010);
		
		song.show();
		
		Global.globalFunc();
		globalTest();
		
		Song song2 = new Song("잉기마르손","곤방와");
		song2.show();
	}
	
	public static void globalTest() {
		System.out.println(Global.globalVar);
		Global.globalFunc();
	}

}
