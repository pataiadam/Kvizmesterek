package kvizmester.beans.statistics;

public class CategoryLevel {
	private String name;
	
	private double level;
	
	public CategoryLevel(String name, double level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}
	
	

}
