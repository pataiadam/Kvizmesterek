package kvizmester.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kvizmester.test.Test;

public class Game {
	private String player1;
	private String player2;
	private boolean player1IsHere = false;
	private boolean player2IsHere = false;
	private int tmp;
	private List<Question> questions = new ArrayList<>();
	private int[] categories;
	String[] categoriesName;
	private Random gen = new Random();

	public Game(String player1) {
		Test test = new Test();
		this.categories=generateCategory(test);
		generateQuestions(test, this.categories);
		this.player1 = player1;
	}

	private int[] generateCategory(Test test) {
		int[] catIdArray = new int[5];
		categoriesName = new String[5];
		for (int i = 0; i < 5; i++) {
			catIdArray[i] = 0;
			int rand= gen.nextInt(test.getAllCategory().size());
			int catId = test.getAllCategory()
					.get(rand).getId();
			boolean vanmar = false;
			for (int j = 0; j < i; j++) {
				if (catIdArray[j] == catId) {
					vanmar = true;
					i--;
				}
			}
			if (vanmar == false) {
				catIdArray[i] = catId;
				categoriesName[i] = test.getAllCategory().get(rand).getNev();
			}
		}
		
		return catIdArray;
	}
	
	private List<Question> generateQuestions(Test test, int[] catIds){
		for(int i=0; i<catIds.length; i++){
			int qSize =test.getAllQuestionsFromCategory(catIds[i]).size();
			for(int j=0; j<5; j++){
				this.questions.add(test.getAllQuestionsFromCategory(catIds[i]).get(gen.nextInt(qSize)));
				System.out.println(questions.get(questions.size()-1).getQuestion());
			}
		}
		
		return null;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public boolean isPlayer1IsHere() {
		return player1IsHere;
	}

	public void setPlayer1IsHere(boolean player1IsHere) {
		this.player1IsHere = player1IsHere;
	}

	public boolean isPlayer2IsHere() {
		return player2IsHere;
	}

	public void setPlayer2IsHere(boolean player2IsHere) {
		this.player2IsHere = player2IsHere;
	}

	public int getTmp() {
		return tmp;
	}

	public void setTmp(int tmp) {
		this.tmp = tmp;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int[] getCategories() {
		return categories;
	}

	public void setCategories(int[] categories) {
		this.categories = categories;
	}
	
	public String[] getCategoriesName() {
		return categoriesName;
	}

}
