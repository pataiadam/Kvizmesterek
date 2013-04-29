package kvizmester.oracledatabase;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Feltolt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OracleConnection test = new OracleConnection();

		try {
			FileInputStream fstream = new FileInputStream("c:\\KERDESEK.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  int i = 0;
			  while ((strLine = br.readLine()) != null)   {
				  i++;
				  if(i % 5 != 0) {
					  continue;
				  }
				  String[] strt = strLine.split(";");
				  int level = Integer.parseInt(strt[0]);
				  String question = strt[1];
				  int category = Integer.parseInt(strt[7]) + 1;
				  String helyes = strt[6];
				  String answer = "";
				  String wrongAnswer1 = "";
				  String wrongAnswer2 = "";
				  String wrongAnswer3 = "";
				  if(helyes.equals("A")) {
					  answer = strt[2];
					  wrongAnswer1 = strt[3];
					  wrongAnswer2 = strt[4];
					  wrongAnswer3= strt[5];
				  }
				  if(helyes.equals("B")) {
					  answer = strt[3];
					  wrongAnswer1 = strt[2];
					  wrongAnswer2 = strt[4];
					  wrongAnswer3 = strt[5];
				  }
				  if(helyes.equals("C")) {
					  answer = strt[4];
					  wrongAnswer1 = strt[3];
					  wrongAnswer2 = strt[2];
					  wrongAnswer3 = strt[5];
				  }
				  if(helyes.equals("D")) {
					  answer = strt[5];
					  wrongAnswer1 = strt[3];
					  wrongAnswer2 = strt[4];
					  wrongAnswer3 = strt[2];
				  }
				  
				  test.uploadQuestion(category, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, level);
			  }
			  //Close the input stream
			  in.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}

	}
}
