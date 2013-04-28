package kvizmester.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import kvizmester.beans.Game;
import kvizmester.beans.Question;
import kvizmester.beans.Room;
import kvizmester.common.BaseActionBean;
import kvizmester.test.Test;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.ajax.JavaScriptResolution;

public class MainGameActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/web/mainGame.jsp";
	private String me;
	private String roomName;
	private Game game;
	private Question question;
	private ArrayList<String> answers = new ArrayList<>();
	private int[] categories;
	private int qNumber;
	private String ans;
	private boolean firstPlayer;
	private String whoIsNext = "";

	@DefaultHandler
	public Resolution mainGame() {
		Game tmp= GameActionBean.getGames().get(roomName);
		if (me.equals(tmp.getPlayer1()) || me.equals(tmp.getPlayer2())) {
			this.game = GameActionBean.getGames().get(roomName);
			this.categories=game.getCategories();
			whoIsNext = GameActionBean.getGames().get(roomName).whoIsNext();
			return new ForwardResolution(VIEW);
		}
		return new RedirectResolution(GameActionBean.class);
	}
	
	public Resolution clickedOnQuestion(){
		this.game = GameActionBean.getGames().get(roomName);
		whoIsNext = GameActionBean.getGames().get(roomName).whoIsNext();
		System.out.println("AAAAAAAAAAAAAAAA user: "+getUser()+"whoN: "+whoIsNext);
		if(!(getUser().getUsername().equals(whoIsNext))){
		this.question=game.getQuestions().get(qNumber);
		this.answers.add(this.question.getAnswer());
		this.answers.add(this.question.getWrongAnswer1());
		this.answers.add(this.question.getWrongAnswer2());
		this.answers.add(this.question.getWrongAnswer3());
		Collections.shuffle(answers);
		if(this.game.getAskedQuestions()[qNumber]!=1){
			int [] tmp= this.game.getAskedQuestions();
			tmp[qNumber]=1;
			this.game.setAskedQuestions(tmp);
		}
		
		return new ForwardResolution("/WEB-INF/web/test.jsp");
		}
		return new ForwardResolution("/WEB-INF/web/noTest.jsp");
	}
	
	public Resolution questionHandler(){
		System.out.println("ajax");
		whoIsNext = GameActionBean.getGames().get(roomName).whoIsNext();
		System.out.println("pontok: "+GameActionBean.getGames().get(roomName).getPlayer1Point()+" "+GameActionBean.getGames().get(roomName).getPlayer2Point());
		ArrayList<Integer> asked = new ArrayList<>();
		int j=0;
		for(int i : GameActionBean.getGames().get(roomName).getAskedQuestions()){
			asked.add(i);
			if(i==1){
				j++;
			}
		}
		if(GameActionBean.getGames().get(roomName).isPlayer1IsNext()){
			asked.add(100);	
		}
		else{
			asked.add(200);
		}
			
			if(j>=9){
				Room room = null;
				for(Room r : GameActionBean.getStaticRooms()){
					if(r.getRoomName().equals(roomName)){
						room=r;
					}
				}
				GameActionBean.getStaticRooms().remove(room);
			}
		return new JavaScriptResolution(asked);
	}
	
	public Resolution answerTheQuestion(){
		System.out.println("answer");
		this.game = GameActionBean.getGames().get(roomName);
		this.question=game.getQuestions().get(qNumber);
		String ujAns = "";
		try {
			byte[] ptext = ans.getBytes("ISO-8859-1");
			ujAns = new String(ptext); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ujAns);
		System.out.println(question.getAnswer());
		Test test=new Test();
		String asked = "Helytelen!";
		if(ujAns.equals(question.getAnswer())){
			asked="Helyes!";
			
			if(game.getPlayer2().equals(getUser().getUsername())){
				game.setPlayer1Point(game.getPlayer1Point()+question.getLevel());
				test.updateStatistics(game.getPlayer1Id(), question.getCategoryId(), true);
			}else{
				game.setPlayer2Point(game.getPlayer2Point()+question.getLevel());
				test.updateStatistics(game.getPlayer2Id(), question.getCategoryId(), true);
			}
		}
		else{
			if(game.getPlayer2().equals(getUser().getUsername())){
				game.setPlayer1Point(game.getPlayer1Point()-question.getLevel());
				test.updateStatistics(game.getPlayer1Id(), question.getCategoryId(), false);
			}else{
				game.setPlayer2Point(game.getPlayer2Point()-question.getLevel());
				test.updateStatistics(game.getPlayer2Id(), question.getCategoryId(), false);
			}
		}
		
		if(GameActionBean.getGames().get(roomName).isPlayer1IsNext()){
			GameActionBean.getGames().get(roomName).setPlayer1IsNext(false);
		}
		else{
			GameActionBean.getGames().get(roomName).setPlayer1IsNext(true);		
		}
		
		return new JavaScriptResolution(asked);
	}
	 

	public Resolution pointsHandler(){
		int[] points = new int[2];
		this.game=GameActionBean.getGames().get(roomName);
		points[0]=game.getPlayer1Point();
		points[1]=game.getPlayer2Point();
		
		return new JavaScriptResolution(points);
	}

	public Resolution gameEnd(){
		Test test = new Test();
		this.game=GameActionBean.getGames().get(roomName);
		test.updateScore(game.getPlayer1Id(), game.getPlayer1Point());
		test.updateScore(game.getPlayer2Id(), game.getPlayer2Point());
		int player1p=game.getPlayer1Point()-game.getPlayer1StartPoint();
		int player2p=game.getPlayer2Point()-game.getPlayer2StartPoint();
		String winner = "";
		if(player1p>player2p){
			winner=game.getPlayer1();
			test.uploadVerseny(game.getPlayer1Id(), new Date());
		}else{
			winner=game.getPlayer2();
			test.uploadVerseny(game.getPlayer2Id(), new Date());
		}
		
		try {
			test.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JavaScriptResolution(winner);
	}

	public String getMe() {
		return me;
	}

	public void setMe(String me) {
		this.me = me;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getqNumber() {
		return qNumber;
	}

	public void setqNumber(int qNumber) {
		this.qNumber = qNumber;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int[] getCategories() {
		return categories;
	}

	public void setCategories(int[] categories) {
		this.categories = categories;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public boolean isFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(boolean firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getWhoIsNext() {
		return whoIsNext;
	}

	public void setWhoIsNext(String whoIsNext) {
		this.whoIsNext = whoIsNext;
	}

}
