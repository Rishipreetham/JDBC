package com.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcConnection {
private JdbcConnection()
{
	
}
public static Connection getConnection() throws SQLException
{
	//Resources
	Connection connection =null;

	String url="jdbc:mysql://localhost:3306/enterprisejavabatch";
	String username="root";
	String password="root";
	
	connection=DriverManager.getConnection(url,username,password);
	
	return connection;
}
public static void removeConnection(ResultSet resultset,Statement stmt,Connection connection) throws SQLException
{
	if(resultset!=null)
	{
		resultset.close();
	}
	if(stmt!=null)
	{
		stmt.close();
	}
	if(connection!=null)
	{
		connection.close();
	}
}
}
