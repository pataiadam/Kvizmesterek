package kvizmester.action;

import java.util.List;

import kvizmester.beans.statistics.UserWonGames;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class UserWonGamesActionBean extends BaseActionBean {
public static final String VIEW = "/WEB-INF/web/statistics/userWonGames.jsp";
	
	private List<UserWonGames> userWonGames;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		userWonGames = test.getUserWonStatistics();
		return new ForwardResolution(VIEW);
	}

	public List<UserWonGames> getUserWonGames() {
		return userWonGames;
	}

	public void setUserWonGames(List<UserWonGames> userWonGames) {
		this.userWonGames = userWonGames;
	}
}
