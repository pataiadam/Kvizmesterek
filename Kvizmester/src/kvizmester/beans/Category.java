package kvizmester.beans;

public class Category {

	private int id;
	private String nev;
	
	public Category(int id, String nev) {
		this.id = id;
		this.nev = nev;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}
}
