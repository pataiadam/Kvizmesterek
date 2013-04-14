package kvizmester.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kvizmester.beans.Game;
import kvizmester.beans.Room;
import kvizmester.common.BaseActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

public class GameActionBean extends BaseActionBean {
	
	private static final String VIEW = "/WEB-INF/web/game.jsp";
	private String text;
	private String me = "EnvagyokASzobaLetrehozoja";
	private String player;
	private static ArrayList<Room> rooms = new ArrayList<>();
	private static Map<String, Game> games = new HashMap<>();
	
	static{
	}
	
	@DefaultHandler
	public Resolution game() {
		return new ForwardResolution(VIEW);
	}

    public Resolution submit() {
    	Room tmpR = new Room(text, player);
    	Game tmpG = new Game(player);
    	tmpG.setPlayer2(me);
    	rooms.add(tmpR);
    	games.put(text, tmpG);
        return new RedirectResolution(GameActionBean.class);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	
	public static ArrayList<Room> getStaticRooms() {
		return rooms;
	}

	public static Map<String, Game> getGames() {
		return games;
	}


}
