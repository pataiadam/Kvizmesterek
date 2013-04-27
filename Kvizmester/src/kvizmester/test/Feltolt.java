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

		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("c:\\KERDESEK.csv");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				i++;
				if(! (i % 4 == 0)) {
					continue;
				}
				String[] str = strLine.split(";");
				int level = Integer.parseInt(str[0]);
				String question = str[1];
				int category = Integer.parseInt(str[7]) + 1;
				String helyes = str[6];
				String answer = null;
				String wrongAnswer1 = null;
				String wrongAnswer2 = null;
				String wrongAnswer3 = null;
				if(helyes.equals("A")) {
					answer = str[2];
					wrongAnswer1 = str[3];
					wrongAnswer2 = str[4];
					wrongAnswer3 = str[5];
				}
				if(helyes.equals("B")) {
					answer = str[3];
					wrongAnswer1 = str[2];
					wrongAnswer2 = str[4];
					wrongAnswer3 = str[5];
				}
				if(helyes.equals("C")) {
					answer = str[4];
					wrongAnswer1 = str[3];
					wrongAnswer2 = str[2];
					wrongAnswer3 = str[5];
				}
				if(helyes.equals("D")) {
					answer = str[5];
					wrongAnswer1 = str[3];
					wrongAnswer2 = str[4];
					wrongAnswer3 = str[2];
				}
				
test.uploadQuestion(category, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, level);				
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}

	}

}
