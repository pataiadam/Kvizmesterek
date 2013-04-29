package kvizmester.action;

import java.util.List;

import kvizmester.beans.statistics.UserForumComments;
import kvizmester.beans.statistics.UserHighScoreByCategory;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class UserForumCommentsActionBean extends BaseActionBean {
public static final String VIEW = "/WEB-INF/web/statistics/userForumComments.jsp";
	
	private List<UserForumComments> userForumComments;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		userForumComments = test.getUserForumCommentsStatistics();
		return new ForwardResolution(VIEW);
	}

	public List<UserForumComments> getUserForumComments() {
		return userForumComments;
	}

	public void setUserForumComments(List<UserForumComments> userForumComments) {
		this.userForumComments = userForumComments;
	}

	
}
