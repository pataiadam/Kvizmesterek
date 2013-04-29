package kvizmester.action;

import java.util.Date;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import kvizmester.beans.User;
import kvizmester.common.BaseActionBean;
import kvizmester.common.EmailValidator;
import kvizmester.oracledatabase.OracleConnection;

public class ModifyRegActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/modifyReg.jsp";
	
	private String username;
	
	private String oldpassword;
	
	private String password;
	
	private String password2;
	
	private Date birthdate;
	
	private String email;
	
	private int id;
	
	@DefaultHandler
	public Resolution view() {
		User user = getContext().getUser();
		username = user.getUsername();
		if(oldpassword != null || password != null || password2 != null || birthdate != null || email != null) {
			return modifyReg();
		}

		birthdate = user.getBirthdate();
		email = user.getEmail();
		id = user.getId();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution modifyReg() {
		int hiba = 0;
		
		if(birthdate == null || email == null || birthdate.equals("") || email.equals("")) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Minden mező megadása kötelező (új jelszót nem kell megadni, ha nem akarja megváltoztatni)!") );
			hiba++;
		}
		
		if((password != null || password2 != null) && password.length() < 8 ) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Az új jelszó legalább 8 karakter kell, hogy legyen!") );
			hiba++;
		}
		else if((password != null || password2 != null) && !(password.equals(password2))) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("A két új jelszó nem egyezik meg!") );
			hiba++;
		}
		
		
		
		OracleConnection test = new OracleConnection();
		
		boolean validate = test.validateUser(username, oldpassword);
		if(! validate) {
			hiba++;
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hibásan adta meg a jelenlegi jelszót!") );
		}
		
		if(hiba == 0 && password != null && password2 != null) {
			oldpassword = password;
		}
		
		if(hiba == 0) {
			boolean success = test.modifyUser(id, email, birthdate, oldpassword);
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
			getContext().getMessages().add(new LocalizableMessage("modify.successful"));
			User user = new User(getContext().getUser().getRole(), id, username, email, birthdate, getContext().getUser().getRegDate(), getContext().getUser().getScore());
			getContext().setUser(user);
		}
		
		return new ForwardResolution(VIEW);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
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
