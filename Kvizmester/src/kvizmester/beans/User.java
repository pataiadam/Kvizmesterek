package kvizmester.beans;

import java.util.Date;

import kvizmester.utils.Role;

public class User {
	private int id;
	
	private String username;
	
	private String email;
	
	private Date birthdate;
	
	private Date regDate;
	
	private int score;
	
	private Role role;
	
	public User(Role role, int id, String username, String email, Date birthdate, Date regDate, int score) {
		this.role = role;
		this.id = id;
		this.username = username;
		this.email = email;
		this.birthdate = birthdate;
		this.regDate = regDate;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
