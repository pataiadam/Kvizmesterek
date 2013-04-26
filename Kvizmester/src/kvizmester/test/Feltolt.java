package kvizmester.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import kvizmester.beans.Category;
import kvizmester.beans.Question;

public class Feltolt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test test = new Test();
		
		test.getAllCategory();
		
		List<Question> q = test.getAllQuestionsFromCategory(20);
		
		for(Question q1 : q) {
			System.out.println(q1.getQuestion() + " : " + q1.getAnswer() + " : " + q1.getLevel());
		}
	}

}
