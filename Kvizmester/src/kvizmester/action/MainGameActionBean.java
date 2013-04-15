package kvizmester.action;

import kvizmester.beans.Game;
import kvizmester.common.BaseActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class MainGameActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/web/mainGame.jsp";
	private String player1;
	private String roomName;
	private Game game;

	@DefaultHandler
	public Resolution mainGame() {
		
		this.game=GameActionBean.getGames().get(roomName);
		GameActionBean.getGames().get(roomName).setTmp(GameActionBean.getGames().get(roomName).getTmp()+1);
		
		return new ForwardResolution(VIEW);
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
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

}
