
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class DeleteOperation {

	public static void delete() {

		//Resources
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			connection=JdbcConnection.getConnection();
			
			System.out.println("enter id");
			int id=sc.nextInt();
			
			String deletequery="delete from student where sid=?";
			
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(deletequery);
			}
			
			
			if(pstmt!=null)
			{
				pstmt.setInt(1, id);
				int noofrows=pstmt.executeUpdate();
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
				JdbcConnection.removeConnection(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
				sc.close();
		}
	}

}
