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

import kvizmester.beans.User;
import kvizmester.utils.Role;

/**
 * Servlet implementation class Test
 */
@WebServlet(description = "Test Servlet", urlPatterns = { "/test" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.110.10.1:1521:xe", "SYSTEM", "admin");

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
	
	public User getUserByUsername(String username) {
		User user = null;
		
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
				
				
				int admin = rs.getInt("admin");
				Role role;
				if(admin == 1) {
					role = Role.ADMIN;
				} else {
					role = Role.USER;
				}
				
				user = new User(role, id, username, email, birthdate, score);
				
				System.out.println(user.getRole() + "\n" + user.getUsername() + user.getBirthdate());
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
		
		return user;
	}
	
	public boolean registerNewUser(String username, String password, String email, Date birthdate) {
		
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
		 
		String selectId = "SELECT MAX(jatekos_id) FROM jatekos";
		
		String insertUser = "INSERT INTO jatekos VALUES (?, ?, ?, ?, ?, ?, ?)";
 
		try {
			preparedStatement = connection.prepareStatement(selectId);
			ResultSet rs = preparedStatement.executeQuery();
			
			int id = 0;
			
			while(rs.next()) {
				id = rs.getInt("MAX(jatekos_id)");
			}
			
			id++;
			
			int score = 50;
			
			
			java.sql.Date sqlDate = new java.sql.Date(birthdate.getTime());
			
			preparedStatement = connection.prepareStatement(insertUser);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, score);
			preparedStatement.setDate(6, sqlDate);
			preparedStatement.setInt(7, 0);
 
			// execute select SQL stetement
			rs = preparedStatement.executeQuery();
 
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
 
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	public boolean modifyUser(int id, String email, Date birthdate, String password) {
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
 
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		
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
				Date birthdate = new Date(rs.getDate("szuletesnap").getTime());
				int admin = rs.getInt("admin");
				Role role;
				if(admin == 1) {
					role = Role.ADMIN;
				} else {
					role = Role.USER;
				}
				User user = new User(role, id, username, email, birthdate, score);
				
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
 
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return users;
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
