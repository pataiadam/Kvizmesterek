package kvizmester.beans.statistics;

public class UserForumComments {
	private String username;
	
	private int numOfComments;
	
	public UserForumComments(String username, int numOfComments) {
		this.username = username;
		this.numOfComments = numOfComments;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNumOfComments() {
		return numOfComments;
	}

	public void setNumOfComments(int numOfComments) {
		this.numOfComments = numOfComments;
	}
	
	
}
