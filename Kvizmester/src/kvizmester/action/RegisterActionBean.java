package kvizmester.action;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kvizmester.beans.User;
import kvizmester.common.BaseActionBean;
import kvizmester.common.EmailValidator;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;

public class RegisterActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/register.jsp";
	
	public static final String LOGIN_VIEW = "/WEB-INF/web/login.jsp";
	
	private String username;
	
	private String password;
	
	private String password2;
	
	private Date birthdate;
	
	private String email;
	
	@DefaultHandler
	public Resolution view() {
		if(username != null || password != null || password2 != null || birthdate != null) {
			return register();
		}
		return new ForwardResolution(VIEW);
	}
	
	public Resolution register() {
		int hiba = 0;
		
		if(username == null || birthdate == null || email == null || username.equals("") || birthdate.equals("") || email.equals("")) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Minden mező megadása kötelező!") );
			hiba++;
		}
		
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
		
		OracleConnection test = new OracleConnection();
		
		User user = test.getUserByUsername(username);
		
		if(user != null) {
			hiba++;
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Foglalt felhasználónév!") );
		}
		
		
		if(hiba == 0) {
			boolean success = test.registerNewUser(username, password, email, birthdate);
			if(! success) {
				hiba++;
				getContext().getValidationErrors().addGlobalError(
		                new SimpleError("Hiba az adatbázisművelet során!") );
			}
			
		}
		
		EmailValidator validator = new EmailValidator();
		
		if(! validator.validate(email)) {
			hiba++;
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hibás e-mail cím!") );
		}
		
		if(hiba == 0) {
			getContext().getMessages().add(new LocalizableMessage("register.successful"));
		}
		return new ForwardResolution(LOGIN_VIEW);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
