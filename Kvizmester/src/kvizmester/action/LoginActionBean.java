package kvizmester.action;

import kvizmester.beans.User;
import kvizmester.common.BaseActionBean;
import kvizmester.test.Test;
import kvizmester.utils.Role;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

public class LoginActionBean extends BaseActionBean {

	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/login.jsp";

	/**
	 * The username.
	 */
	private String username;

	/**
	 * The password.
	 */
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Default handler. Returns the current view if no user is logged in.
	 * Otherwise forwards to the main page.
	 * 
	 * @return VIEW
	 */
	@DefaultHandler
	@DontValidate
	public Resolution view() {
		if (getContext().getUser() != null) {
			return new RedirectResolution(HomeActionBean.class);
		}
		if(username != null || password != null) {
			return login();
		}
		return new ForwardResolution(VIEW);
	}
	
	public Resolution login() {
		Test test = new Test();
		

		if (test.validateUser(username, password)) {
			User user = test.getUserByUsername(username);
			getContext().setUser(user);
			return new RedirectResolution(HomeActionBean.class);
		}
		if (getContext().getUser() != null) {
			return new RedirectResolution(HomeActionBean.class);
		}
		getContext().getValidationErrors().addGlobalError(
                new SimpleError("Hibás belépési adatok!") );
		return new ForwardResolution(VIEW);
	}
}