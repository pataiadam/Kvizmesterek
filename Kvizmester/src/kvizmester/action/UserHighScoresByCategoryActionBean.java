package kvizmester.action;

import java.util.List;

import kvizmester.beans.statistics.UserHighScoreByCategory;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class UserHighScoresByCategoryActionBean extends BaseActionBean {
public static final String VIEW = "/WEB-INF/web/statistics/userHighScoresByCategory.jsp";
	
	private List<UserHighScoreByCategory> userHighScoresByCategory;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		userHighScoresByCategory = test.getUserHighScoresByCategory();
		return new ForwardResolution(VIEW);
	}

	public List<UserHighScoreByCategory> getUserHighScoresByCategory() {
		return userHighScoresByCategory;
	}

	public void setUserHighScoresByCategory(
			List<UserHighScoreByCategory> userHighScoresByCategory) {
		this.userHighScoresByCategory = userHighScoresByCategory;
	}
}
