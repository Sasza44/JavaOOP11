package stream.api3;

import java.util.Arrays;

public class Singer {
	private String name;
	private String[] songs;
	
	public Singer(String name, String[] songs) {
		super();
		this.name = name;
		this.songs = songs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSongs() {
		return songs;
	}
	public void setSongs(String[] songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Singer [name=" + name + ", songs=" + Arrays.toString(songs) + "]";
	}
}