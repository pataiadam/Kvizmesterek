package kvizmester.action;

import java.util.List;

import kvizmester.beans.User;
import kvizmester.common.BaseActionBean;
import kvizmester.test.Test;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class UsersActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/admin/users.jsp";
	
	private List<User> users;
	
	@DefaultHandler
	public Resolution view() {
		Test test = new Test();
		
		users = test.getAllUsers();
		
		return new ForwardResolution(VIEW);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
