package kvizmester.beans;

public class Question {

	private int id;
	
	private int categoryId;
	
	private String category;
	
	private String question;
	
	private String answer;

	private String wrongAnswer1;

	private String wrongAnswer2;

	private String wrongAnswer3;
	
	private int level;
	
	private int numberOfAsked;
	
	private int numberOfAnswered;
	
	public Question(int id, int categoryId, String category, String question, String answer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, int level, int numberOfAsked, int numberOfAnswered) {
		this.id = id;
		this.categoryId = categoryId;
		this.category = category;
		this.question = question;
		this.answer = answer;
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
		this.level = level;
		this.numberOfAsked = numberOfAsked;
		this.numberOfAnswered = numberOfAnswered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumberOfAsked() {
		return numberOfAsked;
	}

	public void setNumberOfAsked(int numberOfAsked) {
		this.numberOfAsked = numberOfAsked;
	}

	public int getNumberOfAnswered() {
		return numberOfAnswered;
	}

	public void setNumberOfAnswered(int numberOfAnswered) {
		this.numberOfAnswered = numberOfAnswered;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
