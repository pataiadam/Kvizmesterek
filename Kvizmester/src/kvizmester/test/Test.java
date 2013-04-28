package kvizmester.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kvizmester.beans.Advertising;
import kvizmester.beans.Category;
import kvizmester.beans.Question;
import kvizmester.beans.User;
import kvizmester.utils.Role;

/**
 * Servlet implementation class Test
 */
@WebServlet(description = "Test Servlet", urlPatterns = { "/test" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
	
	private Connection connection = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {	
		super();
		try {
			connection = this.connect();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public Connection connect() throws ServletException, IOException {
		
		if(connection != null) {
			return connection;
		}

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		connection = null;

		try {
			
			/**------------------------------------------------------------**/
			String serverName = "10.110.10.1"; 
			String portNumber = "1521";
			String sid = "xe";
			String url="jdbc:oracle:thin:@"+serverName+":"+ portNumber+":"+sid; 
			String user = "SYSTEM";
			String pass = "admin"; 
			/**------------------------------------------------------------**/
			
			
			


			connection = DriverManager.getConnection(url, user, pass);
					
					
					
					

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		return connection;
	}
	
	public boolean validateUser(String username, String password) {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		PreparedStatement preparedStatement = null;
		 
		String selectSQL = "SELECT * FROM jatekos WHERE felhasznalo_nev=? AND jelszo=?";
 
		try {
			
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			System.out.println(preparedStatement.execute());
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			int foundUsers = 0;
			
			System.out.println(rs.getFetchSize());
 
			while (rs.next()) {
				foundUsers++;
			}
			
			
			System.out.println(username);
			System.out.println(password);

			System.out.println(foundUsers);
			if(foundUsers > 0) {
				return true;
			} else {
				return false;
			}
			
			
 
		} catch (Exception e) {
			e.printStackTrace();
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public User getUserByUsername(String username) {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		User user = null;
		
		PreparedStatement preparedStatement = null;
		 
		String selectSQL = "SELECT * FROM jatekos WHERE felhasznalo_nev=?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
			while (rs.next()) {
				String email = rs.getString("email");
				int id = rs.getInt("jatekos_id");
				int score = rs.getInt("pontszam");
				java.sql.Date birth = rs.getDate("szuletesnap");
				Date birthdate;
				if(birth == null) {
					birthdate = new Date();
				} else {
					birthdate = new Date(rs.getDate("szuletesnap").getTime());
				}
				java.sql.Date reg = rs.getDate("regdate");
				Date regDate;
				if(reg == null) {
					regDate = new Date();
				} else {
					regDate = new Date(rs.getDate("regdate").getTime());
				}
				
				
				int admin = rs.getInt("admin");
				Role role;
				if(admin == 1) {
					role = Role.ADMIN;
				} else {
					role = Role.USER;
				}
				
				user = new User(role, id, username, email, birthdate, regDate, score);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	
	public boolean registerNewUser(String username, String password, String email, Date birthdate) {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String insertUser = "INSERT INTO jatekos (felhasznalo_nev, email, jelszo, pontszam, szuletesnap, admin) VALUES (?, ?, ?, ?, ?, ?)";
 
		try {
			
			int score = 50;
			
			
			java.sql.Date sqlDate = new java.sql.Date(birthdate.getTime());
			
			preparedStatement = connection.prepareStatement(insertUser);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, score);
			preparedStatement.setDate(5, sqlDate);
			preparedStatement.setInt(6, 0);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	public boolean modifyUser(int id, String email, Date birthdate, String password) {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String insertUser = "UPDATE jatekos SET email=?, jelszo=?, szuletesnap=? WHERE jatekos_id=?";
 
		try {
			
			
			java.sql.Date sqlDate = new java.sql.Date(birthdate.getTime());
			
			preparedStatement = connection.prepareStatement(insertUser);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setInt(4, id);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	public List<User> getAllUsers() {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<User> users = new ArrayList<User>();
		
		PreparedStatement preparedStatement = null;
		
		String getUsers = "SELECT * FROM jatekos";
		
		
		
		
 
		try {
			preparedStatement = connection.prepareStatement(getUsers);
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("jatekos_id");
				String username = rs.getString("felhasznalo_nev");
				String email = rs.getString("email");
				int score = rs.getInt("pontszam");
				java.sql.Date birth = rs.getDate("szuletesnap");
				Date birthdate;
				if(birth == null) {
					birthdate = new Date();
				} else {
					birthdate = new Date(rs.getDate("szuletesnap").getTime());
				}
				java.sql.Date reg = rs.getDate("regdate");
				Date regDate;
				if(reg == null) {
					regDate = new Date();
				} else {
					regDate = new Date(rs.getDate("regdate").getTime());
				}

				int admin = rs.getInt("admin");
				Role role;
				if(admin == 1) {
					role = Role.ADMIN;
				} else {
					role = Role.USER;
				}
				User user = new User(role, id, username, email, birthdate, regDate, score);
				
				users.add(user);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return users;
	}
	
	
	public boolean uploadCategory(String categoryName) {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String insert = "INSERT INTO kategoria(nev) VALUES(?)";		
 
		try {
			
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, categoryName);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	public boolean uploadQuestion(int categoryId, String question, String answer, String answer1, String answer2, String answer3, int level) {
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String insert = "INSERT INTO kerdes(kategoria_id, kerdes_szovege, helyes_valasz, szint,valasz1, valasz2, valasz3) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setString(2,  question);
			preparedStatement.setString(3,  answer);
			preparedStatement.setInt(4, level);
			preparedStatement.setString(5, answer1);
			preparedStatement.setString(6, answer2);
			preparedStatement.setString(7, answer3);
			
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
		
	public List<Category> getAllCategory() {
		List<Category> categoryList = new ArrayList<Category>();
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String maxId = "SELECT * FROM kategoria ORDER BY nev";
 
		try {
			
			preparedStatement = connection.prepareStatement(maxId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("kategoria_id");
				String nev = rs.getString("nev");
				
				Category category = new Category(id, nev);
				
				categoryList.add(category);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return categoryList;
	}
	
	public List<Question> getAllQuestionsFromCategory(int categoryId) {
		List<Question> questionList = new ArrayList<Question>();
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String questions = "SELECT * FROM kerdes LEFT JOIN kategoria ON kerdes.kategoria_id = kategoria.kategoria_id WHERE kerdes.kategoria_id = ?";
 
		try {
			
			preparedStatement = connection.prepareStatement(questions);
			preparedStatement.setInt(1, categoryId);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("kerdes_id");
				String category = rs.getString("nev");
				String question = rs.getString("kerdes_szovege");
				String answer = rs.getString("helyes_valasz");
				String wrongAnswer1 = rs.getString("valasz1");
				String wrongAnswer2 = rs.getString("valasz2");
				String wrongAnswer3 = rs.getString("valasz3");
				int level = rs.getInt("szint");
				int numberOfAsked = rs.getInt("megkerdezve");
				int numberOfAnswered = rs.getInt("megvalaszolva");



				
				
				Question questionObj = new Question(id, categoryId, category, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, level, numberOfAsked, numberOfAnswered);
				
				questionList.add(questionObj);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return questionList;
	}
	
	public List<Question> getAllQuestions() {
		List<Question> questionList = new ArrayList<Question>();
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String questions = "SELECT * FROM kerdes LEFT JOIN kategoria ON kerdes.kategoria_id = kategoria.kategoria_id";
 
		try {
			
			preparedStatement = connection.prepareStatement(questions);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("kerdes_id");
				int categoryId = rs.getInt("kategoria_id");
				String category = rs.getString("nev");
				String question = rs.getString("kerdes_szovege");
				String answer = rs.getString("helyes_valasz");
				String wrongAnswer1 = rs.getString("valasz1");
				String wrongAnswer2 = rs.getString("valasz2");
				String wrongAnswer3 = rs.getString("valasz3");
				int level = rs.getInt("szint");
				int numberOfAsked = rs.getInt("megkerdezve");
				int numberOfAnswered = rs.getInt("megvalaszolva");



				
				
				Question questionObj = new Question(id, categoryId, category, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, level, numberOfAsked, numberOfAnswered);
				
				questionList.add(questionObj);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return questionList;
	}
	
	public List<Advertising> getAllAdvertising() {
		List<Advertising> advertising = new ArrayList<Advertising>();
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "SELECT * FROM reklam";
 
		try {
			
			preparedStatement = connection.prepareStatement(adverts);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("reklam_id");
				String url = rs.getString("url");
				Date beginning = new Date(rs.getDate("datum_kezdo").getTime());
				Date end = new Date(rs.getDate("datum_veg").getTime());
				



				
				
				Advertising advertObj = new Advertising(id, url, beginning, end);
				
				advertising.add(advertObj);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		
		return advertising;
	}
	
	public boolean deleteUserById(int userId) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "DELETE FROM jatekos WHERE jatekos_id = ?";
 
		try {
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, userId);
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public Category getCategoryByName(String categoryName) {
		Category category = null;
		
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "SELECT * FROM kategoria WHERE kategoria.nev = ?";
 
		try {
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setString(1, categoryName);
			
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("kategoria_id");
				
				category = new Category(id, categoryName);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return category;
	}
	
	public boolean deleteCategoryById(int categoryId) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "DELETE FROM kategoria WHERE kategoria_id = ?";
 
		try {
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, categoryId);
			
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean updateCategory(int categoryId, String categoryName) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "UPDATE kategoria SET nev = ? WHERE kategoria_id = ?";
 
		try {
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setString(1, categoryName);
			preparedStatement.setInt(2, categoryId);
			
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean uploadAdvertising(String url, Date beginning, Date end) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "INSERT INTO reklam(url, datum_kezdo, datum_veg) VALUES(?, ?, ?)";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setString(1, url);
			preparedStatement.setDate(2, new java.sql.Date(beginning.getTime()));
			preparedStatement.setDate(3, new java.sql.Date(end.getTime()));
			
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
		
		
		
		
	}
	
	public boolean deleteAdvertisingById(int advertId) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "DELETE FROM reklam WHERE reklam_id = ?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, advertId);
			
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean updateAdvertising(int id, String url, Date beginning, Date end) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "UPDATE reklam SET url = ?, datum_kezdo = ?, datum_veg = ? WHERE reklam_id = ?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setString(1, url);
			preparedStatement.setDate(2, new java.sql.Date(beginning.getTime()));
			preparedStatement.setDate(3, new java.sql.Date(end.getTime()));
			preparedStatement.setInt(4, id);
			
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean updateQuestionById(int id, int categoryId, String question, String answer, String answer1, String answer2, String answer3, int level) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "UPDATE kerdes SET kategoria_id = ?, kerdes_szovege = ?, helyes_valasz = ?, szint = ?, valasz1 = ?, valasz2 = ?, valasz3 = ? WHERE kerdes_id = ?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setString(2, question);
			preparedStatement.setString(3, answer);
			preparedStatement.setInt(4, level);
			preparedStatement.setString(5, answer1);
			preparedStatement.setString(6, answer2);
			preparedStatement.setString(7, answer3);
			preparedStatement.setInt(8, id);


			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean deleteQuestion(int questionId) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "DELETE FROM kerdes WHERE kerdes_id = ?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, questionId);
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean uploadVerseny(int nyertesId, Date idopont) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "INSERT INTO verseny(resztvevok_szama, nyertes_id, idopont) VALUES(2, ?, ?)";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, nyertesId);
			preparedStatement.setDate(2, new java.sql.Date(idopont.getTime()));
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean updateScore(int userId, int score) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "UPDATE jatekos SET pontszam=? WHERE jatekos_id=?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, score);
			preparedStatement.setInt(2, userId);
			
			ResultSet rs = preparedStatement.executeQuery();
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean updateStatistics(int userId, int categoryId, boolean answeredCorrectly) {
		if(connection == null) {
			try {
				connection = this.connect();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PreparedStatement preparedStatement = null;
		
		String adverts = "SELECT * FROM jatekos_statisztika WHERE jatekos_id=? AND kategoria_id=?";
 
		try {
			
			
			preparedStatement = connection.prepareStatement(adverts);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, categoryId);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean talalt = false;
			int helyesValaszok = 0;
			int kerdezve = 0;
			
			while(rs.next()) {
				talalt = true;
				helyesValaszok = rs.getInt("helyes");
				kerdezve = rs.getInt("kerdezve");
			}
			
			kerdezve++;
			
			if(answeredCorrectly) {
				helyesValaszok++;
			}
			
			if(talalt) {
				adverts = "UPDATE jatekos_statisztika SET helyes=?, kerdezve=?  WHERE jatekos_id=? AND kategoria_id=?";
				preparedStatement = connection.prepareStatement(adverts);
				preparedStatement.setInt(1, helyesValaszok);
				preparedStatement.setInt(2, kerdezve);
				preparedStatement.setInt(3, userId);
				preparedStatement.setInt(4, categoryId);
				
				rs = preparedStatement.executeQuery();
			} else {
				adverts = "INSERT INTO jatekos_statisztika(jatekos_id, kategoria_id, helyes, kerdezve) VALUES(?, ?, ?, ?)";
				preparedStatement = connection.prepareStatement(adverts);
				preparedStatement.setInt(1, userId);
				preparedStatement.setInt(2, categoryId);
				preparedStatement.setInt(3, helyesValaszok);
				preparedStatement.setInt(4, kerdezve);
				
				rs = preparedStatement.executeQuery();
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	

}
