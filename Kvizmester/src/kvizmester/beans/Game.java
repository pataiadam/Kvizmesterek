package kvizmester.beans;

public class Game {
	private String player1;
	private String player2;
	private boolean player1IsHere=false;
	private boolean player2IsHere=false;
	private int tmp;
	
	public Game(String player1){
		this.player1=player1;
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
	

}
