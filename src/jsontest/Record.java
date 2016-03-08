package jsontest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Record implements Comparable<Record>{
	private String songName;
	private String singerName;
	private String songTime;
	
	@JsonCreator
	public Record(@JsonProperty ("songName") String songName,@JsonProperty ("singerName;") String singerName,
			@JsonProperty ("songTime") String songTime) {
		super();
		this.songName = songName;
		this.singerName = singerName;
		this.songTime = songTime;
	}
    public String getSongName() {
	return songName;
}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getSongTime() {
		return songTime;
	}

	public void setSongTime(String songTime) {
		this.songTime = songTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((singerName == null) ? 0 : singerName.hashCode());
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (singerName == null) {
			if (other.singerName != null)
				return false;
		} else if (!singerName.equals(other.singerName))
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		return true;
	}
	@Override
	public int compareTo(Record temp) {
		int n = this.songName.compareTo(temp.songName);

		int p = this.singerName.compareTo(temp.singerName);

		if (n != 0)
			return n;
		if (p != 0)
			return p;
		else
			return 0;
	}
	
	
	@Override
	public String toString() {
		return "Record [songName= " + songName + ", singerName= " + singerName + ", songTime= " + songTime + "]";
	}

}