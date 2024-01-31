package person_jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Personmain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the address");
		String address=scanner.next();
		
		Person person=new Person();
		person.setId(id);
		person.setName(name);
		person.setAddress(address);
		
		Personcrud personcrud=new Personcrud();
		try {
			personcrud.saveperson(person);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
