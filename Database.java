package Bootathon;
import java.sql.*;
public class Database {
	Connection conn =null;
	Statement stmt = null;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //legacy way to make JBDC to know the driver
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Bootathon","root","Mouli428@"); //MAKING CONNECTION B/W JAVA AND MySQL
			stmt = conn.createStatement();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loginUser(String userID,String password) {
		try {
			String sql= "SELECT * FROM USERS WHERE userID=\""+userID+"\" and password=\""+password+"\";";
			ResultSet rs =  stmt.executeQuery(sql);
			if(rs.next()) {
				return "1";
			}
			else {
				return "0";
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "1";
	}
	public String registerUser(String userID,String username,String emailId,String password) {
		if(conn==null || stmt==null)
			connect();
		
		try {
			String sql =  "SELECT * FROM USERS WHERE userID=\""+userID+"\";";
			ResultSet rs =  stmt.executeQuery(sql);
			if(rs.next()) {
				return "UserID already exist";
			}
			sql =  "SELECT * FROM USERS WHERE email=\""+emailId+"\";";
			rs =  stmt.executeQuery(sql);
			if(rs.next()) {
				return "EmailID already exist";
			}
			sql = "INSERT INTO USERS VALUES (\""+userID+"\",\""+username+"\",\""+emailId+"\",\""+password+"\");";
			stmt.executeUpdate(sql);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "1";
		
	}
	public void closeConnection() {
		try {
			stmt.close();
			conn.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
