package kvizmester.test;

import java.util.Date;

public class Feltolt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test test = new Test();

		try {
			test.updateStatistics(6, 3, false);
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}

	}

}
