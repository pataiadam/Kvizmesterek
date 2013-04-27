package kvizmester.action;

import java.util.List;

import kvizmester.beans.User;
import kvizmester.common.BaseActionBean;
import kvizmester.test.Test;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;

public class UsersActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/admin/users.jsp";
	
	private List<User> users;
	
	private int deleteUserId;
	
	@DefaultHandler
	public Resolution view() {
		Test test = new Test();
		
		users = test.getAllUsers();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution deleteUserById() {
		Test test = new Test();
		
		if(test.deleteUserById(deleteUserId)) {
			getContext().getMessages().add(new LocalizableMessage("delete.successful"));
		} else {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
		}
		
		users = test.getAllUsers();
		
		return new ForwardResolution(VIEW);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getDeleteUserId() {
		return deleteUserId;
	}

	public void setDeleteUserId(int deleteUserId) {
		this.deleteUserId = deleteUserId;
	}
	
	
	
	
}
