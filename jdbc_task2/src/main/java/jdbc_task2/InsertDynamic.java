package jdbc_task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String ename=scanner.next();
		System.out.println("enter the salary");
		double salary=scanner.nextDouble();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task2", "root", "root");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, ename);
		preparedStatement.setDouble(3, salary);
		
		preparedStatement.execute();
		connection.close();
		System.out.println("inserted");
	}
}
