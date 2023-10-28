package seleniumPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Connection_Program {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
				
		String host ="localhost";
		String port ="3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/sakila","root","P@ssw0rd");
		Statement s = con.createStatement();
		String query="SELECT a.address,a.district,a.phone,c.city\r\n"
				+ "FROM sakila.address as a\r\n"
				+ "join sakila.city as c\r\n"
				+ "on a.city_id=c.city_id;";
		ResultSet rs = s.executeQuery(query);
		int count=0;
		while(rs.next())
		{
			count++;
		}
		System.out.println(count);
	}

}
