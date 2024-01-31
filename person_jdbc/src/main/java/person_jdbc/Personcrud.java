package person_jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Personcrud {

	public Connection getConnection() throws SQLException, IOException {
		//load or register driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//establish connection
		FileInputStream fileInputStream=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		Connection connection=DriverManager.getConnection(properties.getProperty("url"), 
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;
		
	}
	
	
	public Person saveperson(Person person) throws SQLException, IOException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into person values(?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setString(3, person.getAddress());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("inserted");
		return person;
	}
}
