package kvizmester.beans.statistics;

import java.util.Date;

public class UserHighScore {
	private String username;
	
	private int score;
	
	private Date birth;
	
	public UserHighScore(String username, int score, Date birth) {
		this.username = username;
		this.score = score;
		this.birth = birth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
}
