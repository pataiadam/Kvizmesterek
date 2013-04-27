package kvizmester.beans;

import java.util.Date;

public class Advertising {
	private int id;
	
	private String url;
	
	private Date beginning;
	
	private Date end;
	
	public Advertising(int id, String url, Date beginning, Date end) {
		this.id = id;
		this.url = url;
		this.beginning = beginning;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getBeginning() {
		return beginning;
	}

	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	
}
