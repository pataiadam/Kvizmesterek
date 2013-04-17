package kvizmester.action;

import java.util.ArrayList;

import kvizmester.beans.Game;
import kvizmester.beans.Question;
import kvizmester.common.BaseActionBean;
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
	private int[] categories;
	private int qNumber;
	

	@DefaultHandler
	public Resolution mainGame() {
		Game tmp= GameActionBean.getGames().get(roomName);
		if (me.equals(tmp.getPlayer1()) || me.equals(tmp.getPlayer2())) {
			this.game = GameActionBean.getGames().get(roomName);
			this.categories=game.getCategories();
			return new ForwardResolution(VIEW);
		}
		return new RedirectResolution(GameActionBean.class);
	}
	
	public Resolution clickedOnQuestion(){
		this.game = GameActionBean.getGames().get(roomName);
		this.question=game.getQuestions().get(qNumber);
		if(this.game.getAskedQuestions()[qNumber]!=1){
			System.out.println("no");
			int [] tmp= this.game.getAskedQuestions();
			tmp[qNumber]=1;
			this.game.setAskedQuestions(tmp);
		}
		System.out.println("óóóóóóóóó"+qNumber);
		return new ForwardResolution("/WEB-INF/web/test.jsp");
	}
	
	public Resolution questionHandler(){
		System.out.println("asshole");
		ArrayList<Integer> asked = new ArrayList<>();
		for(int i : GameActionBean.getGames().get(roomName).getAskedQuestions()){
			asked.add(i);
		}
		return new JavaScriptResolution(asked);
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


}
