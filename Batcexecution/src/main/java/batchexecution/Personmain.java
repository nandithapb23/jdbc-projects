package batchexecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personmain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/batchexecution", "root", "root");
		
		Person p1=new Person();
		p1.setId(1);
		p1.setName("ram");
		p1.setAddress("chennai");
		
		Person p2=new Person();
		p2.setId(2);
		p2.setName("vijay");
		p2.setAddress("bangalore");
		
		Person p3=new Person();
		p3.setId(3);
		p3.setName("bhuvan");
		p3.setAddress("hyd");
		
		
		List<Person> list=new ArrayList();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into person values(?,?,?)");
		for(Person person:list) {
			preparedStatement.setInt(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getAddress());
			preparedStatement.addBatch();
			System.out.println("inserted");
		}
		preparedStatement.executeBatch();
		connection.close();
	}
}
