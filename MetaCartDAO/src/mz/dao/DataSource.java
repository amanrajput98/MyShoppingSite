package mz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
private static Connection conn=null;
	
	public static Connection doConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		return conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MetaCart", "root", "ajjumudit");
	}
}
