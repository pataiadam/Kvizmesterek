package kvizmester.beans.statistics;

public class UserWonGames {
	private String username;
	
	private int won;
	
	public UserWonGames(String username, int won) {
		this.username = username;
		this.won = won;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}
	
	
}
