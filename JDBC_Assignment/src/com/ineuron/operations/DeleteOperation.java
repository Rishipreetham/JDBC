
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class DeleteOperation {

	public static void delete() {

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
			
			String deletequery=String.format("delete from student where sid=%d",id);
			if(stmt!=null)
			{
				int noofrows=stmt.executeUpdate(deletequery);
				System.out.println("No of rows deleted are ::"+noofrows);
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
