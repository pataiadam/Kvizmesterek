package kvizmester.action;

import java.util.Date;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import kvizmester.common.BaseActionBean;

public class RegisterActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/register.jsp";
	
	private String username;
	
	private String password;
	
	private String password2;
	
	private Date birthdate;
	
	@DefaultHandler
	public Resolution view() {
		if(username != null || password != null || password2 != null || birthdate != null) {
			return register();
		}
		return new ForwardResolution(VIEW);
	}
	
	public Resolution register() {
		int hiba = 0;
		
		if(password == null || password2 == null || password.length() < 8 ) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("A jelszó legalább 8 karakter kell, hogy legyen!") );
			hiba++;
		}
		else if(password == null || password2 == null || !(password.equals(password2))) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("A két jelszó nem egyezik meg!") );
			hiba++;
		}
		
		
		
		return new ForwardResolution(VIEW);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
