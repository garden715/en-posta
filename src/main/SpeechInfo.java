package main;

public class SpeechInfo {
	public String name;
	public int level;
	public int midCount;
	public int satCount;
	public int greCount;

	public SpeechInfo(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.level = 0; // unclassified
		this.midCount = 0;
		this.satCount = 0;
		this.greCount = 0;
	}

	public void determieLevel() {
		this.level = (midCount > satCount) ? (midCount > greCount ? 1 : 3)
				: (satCount > greCount ? 2 : 3);
	}
}
