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
	private String player;
	private static ArrayList<Room> rooms = new ArrayList<>();
	private static Map<Room, Game> games = new HashMap<>();
	
	static{
		rooms.add(new Room("Szoba1", "higate"));
		rooms.add(new Room("QuizRoom", "kacsa123"));
	}
	
	@DefaultHandler
	public Resolution game() {
		return new ForwardResolution(VIEW);
	}
	
    public Resolution joinToRoom() {
    	System.out.println("heyyyyhoooo");
        return new RedirectResolution(MainGameActionBean.class);
    }

    public Resolution submit() {
    	Room tmpR = new Room(text, player);
    	Game tmpG = new Game("asdfg");
    	rooms.add(tmpR);
    	games.put(tmpR, tmpG);
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

	public static Map<Room, Game> getGames() {
		return games;
	}

}
