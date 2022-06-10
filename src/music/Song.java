package music;

public class Song {
	
	private String title;
	private double duration;
	
	Song(String title, double duration){
		this.title = title;
		this.duration = duration;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public String toString() {
		return "Song{"+"title: '"+title+"\'"+", duration = " + duration + '}';
	}
	
}
