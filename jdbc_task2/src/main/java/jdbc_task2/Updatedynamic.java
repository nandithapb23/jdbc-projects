package jdbc_task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Updatedynamic {
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the updating name");
		String name=scanner.next();
		System.out.println("enter the updating salary");
		double salary=scanner.nextDouble();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task2", "root", "root");
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set ename=?,salary=? where id=?");
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, salary);
		preparedStatement.setInt(3, id);
		
		int count=preparedStatement.executeUpdate();
		connection.close();
		System.out.println(count+"row affected");
	}
}
