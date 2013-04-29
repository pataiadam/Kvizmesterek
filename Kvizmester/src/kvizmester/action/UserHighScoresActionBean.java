package kvizmester.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import kvizmester.beans.statistics.CategoryLevel;
import kvizmester.beans.statistics.UserHighScore;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;

public class UserHighScoresActionBean extends BaseActionBean {
	public static final String VIEW = "/WEB-INF/web/statistics/userHighScores.jsp";
	
	private List<UserHighScore> userHighScores;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		userHighScores = test.getUserHighScores();
		return new ForwardResolution(VIEW);
	}

	public List<UserHighScore> getUserHighScores() {
		return userHighScores;
	}

	public void setUserHighScores(List<UserHighScore> userHighScores) {
		this.userHighScores = userHighScores;
	}
}
