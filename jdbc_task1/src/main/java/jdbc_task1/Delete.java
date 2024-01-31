package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load or register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task1", "root", "root");
		
		//create statement
		Statement statement=connection.createStatement();
		
		//execute statement
		statement.execute("delete from student where id=2");
		
		//close
		connection.close();
		System.out.println("deleted");
	}
}
