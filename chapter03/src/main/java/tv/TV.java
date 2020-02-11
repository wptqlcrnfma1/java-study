package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		this.power = on;
	}
	public void channel(int channel) {
		if(!power) {
			return;
		}
		if(channel<1) {
			channel = 0;
		}
		else if(channel>255) {
			channel = 255;
		}
		this.channel = channel;
	}
	public void channel(boolean up) {
		if(up) {
			channel++;
		}
		else {
			channel--;
		}
		 //channel(channel + (up ? 1 : 1)); 삼항연산자
	}
	public void volume(int volume) {
		if(!power) {
			return;
		}
		if(volume>255) {
			volume = 255;
		}
		else if(volume<1) {
			volume = 0;
		}
		this.volume = volume;
	}
	public void volume(boolean up) {
		if(up == true) {
			volume++;
		}
		else {
			volume--;
		}
	}
	public void status() {
		System.out.println("TV[channel-" + this.channel + ", volume = " + this.volume + ", power = " + this.power + "]");
	}
}
