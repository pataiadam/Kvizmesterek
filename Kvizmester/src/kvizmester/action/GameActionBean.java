package kvizmester.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kvizmester.beans.Game;
import kvizmester.beans.Room;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

public class GameActionBean extends BaseActionBean {
	
	private static final String VIEW = "/WEB-INF/web/game.jsp";
	private String text;
	private String myName = "EnvagyokASzobaLetrehozoja";
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
    	OracleConnection test = new OracleConnection();
    	try{
	    	Room tmpR = new Room(text, player);
	    	tmpR.setCreaterName(myName);
	    	Game tmpG = new Game(player);
	    	tmpG.setPlayer2(myName);
	    	tmpG.setPlayer1Point(test.getUserByUsername(player).getScore());
	    	tmpG.setPlayer2Point(test.getUserByUsername(myName).getScore());
	    	tmpG.setPlayer1StartPoint(test.getUserByUsername(player).getScore());
	    	tmpG.setPlayer2StartPoint(test.getUserByUsername(myName).getScore());
	    	tmpG.setPlayer1Id(test.getUserByUsername(player).getId());
	    	tmpG.setPlayer2Id(test.getUserByUsername(myName).getId());
	    	rooms.add(tmpR);
	    	games.put(text, tmpG);
    	}
    	catch(Exception e){
    		//TODO
    		System.out.println("Nincs ilyen felhasználó");
    	}
    	try {
			test.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}


}
