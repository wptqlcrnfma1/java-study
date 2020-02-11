package chapter03;

public class SongApp {

	public static void main(String[] args) {
		Song song = new Song();
		song.setTitle("좋은날");
		song.setArtist("아이유");
		song.setAlbum("Real");
		song.setComposer("이민수");
		song.setTrack(3);
		song.setYear(2010);
		
		song.show();
		System.out.println(Global.globalVar);
		Global.globalFunc();
		
		Song song2 = new Song("Bluemig", "아이유", null, null, 2019, 0);
		song2.show();
		Song song3 = new Song("문도", "문도박사");
		song3.show();
	}
	public static void globalTest() {
		System.out.println(Global.globalVar);
	}
}
