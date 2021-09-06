package H2;
import java.sql.*;

public class Library {
	private static String url = "jdbc:h2:~/test";
	  private static String user = "sa";
	  private static String password = "";
	  private String item;
	  private String description;
	  private int id;
	 
	public static void main(String[] args) throws Exception {


	}
	
	public boolean insert(String item, String description) throws SQLException {
		try {
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement stmt = connection.createStatement();
		String sql = "INSERT INTO library(item,description) VALUES (" + item + "," + description + ")";
		stmt.executeUpdate(sql);
		stmt.close();
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	 return true;

	}
	
	private int executeUpdate(String query) throws SQLException {
		 Connection connection = DriverManager.getConnection(url, user, password);
		Statement stmt = connection.createStatement();
		int result = stmt.executeUpdate(query);
		stmt.close();
		connection.close();
		return result;
	}
	
	
	public boolean update(String item, String description, int id) throws SQLException {
		try {
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement stmt = connection.createStatement();
		String sql = "UPDATE library SET item = " + item + ", description = " + description + " WHERE id = " + id;
		stmt.executeUpdate(sql);
		stmt.close();
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	 return true;

	}
	
	public boolean delete(int id) throws SQLException {
		try {
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement stmt = connection.createStatement();
		String sql = "DELETE FROM library WHERE id = " + id;
		stmt.executeUpdate(sql);
		stmt.close();
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	 return true;

	}
	
	 public boolean showAll() throws SQLException {
		 try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM library";
			stmt.executeUpdate(sql);
			stmt.close();
			connection.close();
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		 return true;
		 
	 }
	
	public boolean createLibraryTable() throws SQLException {
		try {
		String sql = "CREATE TABLE library "
				  + "(id INTEGER auto_increment, "
				  +	"item VARCHAR(255), "
				  +	"description VARCHAR(255), "
				  + "PRIMARY KEY (id))";
		String sqlQuery = "INSERT INTO fabrics " +
	                "VALUES ('Øêàô', 'Description size')";
		executeUpdate(sql);
		executeUpdate(sqlQuery);
		}
		catch(Exception e) {
			System.out.println("The TABLE has already been created");
			return false;
		}
		return true;
	}
}
