package kvizmester.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet(description = "Test Servlet", urlPatterns = { "/test" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection connect() throws ServletException, IOException {

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {
			
			/**------------------------------------------------------------**/
			String serverName = "localhost"; 
			String portNumber = "1521";
			String sid = "xe";
			String url="jdbc:oracle:thin:@"+serverName+":"+ portNumber+":"+sid; 
			String user = "norbertozeke";
			String pass = "aA914666"; 
			/**------------------------------------------------------------**/
			
			
			

			/*connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.110.10.1:1521:xe", "SYSTEM", "admin");*/
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
		
		Connection connection = null;
		
		try {
			connection = this.connect();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement preparedStatement = null;
		 
		String selectSQL = "SELECT * FROM jatekos WHERE felhasznalo_nev=? AND jelszo=?";
 
		try {
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			int foundUsers = 0;
 
			while (rs.next()) {
				foundUsers++;
			}
			
			if(foundUsers > 0) {
				return true;
			} else {
				return false;
			}
 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
 
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
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
