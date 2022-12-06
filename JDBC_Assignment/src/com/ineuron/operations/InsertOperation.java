
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class InsertOperation {

	public static void insert() {

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
			
			System.out.println("enter name");
			String name=sc.next();
			
			System.out.println("enter age");
			int age=sc.nextInt();
			
			System.out.println("enter address");
			String address=sc.next();
			
			String insertquery=String.format("insert into student values(%d,'%s',%d,'%s')",id,name,age,address);
			if(stmt!=null)
			{
				int noofrows=stmt.executeUpdate(insertquery);
				System.out.println("No of rows inserted are ::"+noofrows);
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
