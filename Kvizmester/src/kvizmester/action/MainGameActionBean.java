package kvizmester.action;

import kvizmester.beans.Game;
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

	@DefaultHandler
	public Resolution mainGame() {
		Game tmp= GameActionBean.getGames().get(roomName);
		if (me.equals(tmp.getPlayer1()) || me.equals(tmp.getPlayer2())) {
			this.game = GameActionBean.getGames().get(roomName);
			return new ForwardResolution(VIEW);
		}
		return new RedirectResolution(GameActionBean.class);
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

}
