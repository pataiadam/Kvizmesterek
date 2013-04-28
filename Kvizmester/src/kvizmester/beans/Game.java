package kvizmester.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kvizmester.test.Test;

public class Game {
	private String player1;
	private String player2;
	private int player1Id;
	private int player2Id;
	private int player1Point;
	private int player2Point;
	private boolean player1IsHere = true;
	private boolean player2IsHere = false;
	private boolean player1IsNext= true;
	private int tmp;
	private List<Question> questions = new ArrayList<>();
	private int[] askedQuestions = new int[25]; //1 ha igen, különben nem
	private int[] categories;
	String[] categoriesName;
	private Random gen = new Random();

	public Game(String player1) {
		Test test = new Test();
		this.categories=generateCategory(test);
		generateQuestions(test, this.categories);
		
		
		
		try {
			test.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public int[] getAskedQuestions() {
		return askedQuestions;
	}

	public void setAskedQuestions(int[] askedQuestions) {
		this.askedQuestions = askedQuestions;
	}

	public boolean isPlayer1IsNext() {
		return player1IsNext;
	}

	public void setPlayer1IsNext(boolean player1IsNext) {
		this.player1IsNext = player1IsNext;
	}
	
	public String whoIsNext(){
		System.out.println("WWWWWWWWWWWWWWWWWWWWW "+player1IsNext);
		System.out.println(player1 + " " + player2);
		if(player1IsNext){
			return player1;
		}
		else{
			return player2;
		}
	}

	public int getPlayer1Point() {
		return player1Point;
	}

	public void setPlayer1Point(int player1Point) {
		this.player1Point = player1Point;
	}

	public int getPlayer2Point() {
		return player2Point;
	}

	public void setPlayer2Point(int player2Point) {
		this.player2Point = player2Point;
	}

	public int getPlayer1Id() {
		return player1Id;
	}

	public void setPlayer1Id(int player1Id) {
		this.player1Id = player1Id;
	}

	public int getPlayer2Id() {
		return player2Id;
	}

	public void setPlayer2Id(int player2Id) {
		this.player2Id = player2Id;
	}

}
