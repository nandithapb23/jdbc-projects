package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.load or register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1", "root", "root");
		
		//create statement
		Statement statement=connection.createStatement();
		
		//execute statment
		int count=statement.executeUpdate("update student set sname='divya' where id=1");
		
		//close
		connection.close();
		System.out.println(count+"rows affected");
	}
}
