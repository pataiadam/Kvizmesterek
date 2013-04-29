package kvizmester.beans.statistics;

public class UserHighScoreByCategory {
	private String username;
	
	private int score;
	
	private String category;
	
	private double relativeAnswers;
	
	public UserHighScoreByCategory(String username, int score, String category, double relativeAnswers) {
		this.username = username;
		this.score = score;
		this.category = category;
		this.relativeAnswers = relativeAnswers;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRelativeAnswers() {
		return relativeAnswers;
	}

	public void setRelativeAnswers(double relativeAnswers) {
		this.relativeAnswers = relativeAnswers;
	}
	
	
}
