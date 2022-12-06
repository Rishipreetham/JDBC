
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class UpdateOperation {

	public static void update() {

		//Resources
		Connection connection=null;
		Statement stmt=null;
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			connection=JdbcConnection.getConnection();
			if(connection!=null)
			{
				stmt=connection.createStatement();
			}
			
			System.out.println("enter id");
			int id=sc.nextInt();
			
			String updatequery=String.format("update student set saddr='N/A' where sid=%d",id);
			if(stmt!=null)
			{
				int noofrows=stmt.executeUpdate(updatequery);
				System.out.println("No of rows updated are ::"+noofrows);
			}
			
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				JdbcConnection.removeConnection(null, stmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
				sc.close();
		}
	}

}
