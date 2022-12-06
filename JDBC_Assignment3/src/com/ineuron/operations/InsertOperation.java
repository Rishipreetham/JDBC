
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class InsertOperation {

	public static void insert() {

		//Resources
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			connection=JdbcConnection.getConnection();
			
			System.out.println("enter id");
			int id=sc.nextInt();
			
			System.out.println("enter name");
			String name=sc.next();
			
			System.out.println("enter age");
			int age=sc.nextInt();
			
			System.out.println("enter address");
			String address=sc.next();
			
			String insertquery="insert into student values(?,?,?,?)";

			if(connection!=null)
			{
				pstmt=connection.prepareStatement(insertquery);
			}
			
			
			if(pstmt!=null)
			{
				pstmt.setInt(1,id);
				pstmt.setString(2, name);
				pstmt.setInt(3,age);
				pstmt.setString(4, address);
				int noofrows=pstmt.executeUpdate();
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
				JdbcConnection.removeConnection(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
				sc.close();
		}
	}

}
