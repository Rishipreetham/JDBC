
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class UpdateOperation {

	public static void update() {

		//Resources
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			connection=JdbcConnection.getConnection();
			
			System.out.println("enter id");
			int id=sc.nextInt();
			
			String updatequery="update student set saddr='N/A' where sid=?";

			if(connection!=null)
			{
				pstmt=connection.prepareStatement(updatequery);
			}
			
			
			
			if(pstmt!=null)
			{
				pstmt.setInt(1, id);
				int noofrows=pstmt.executeUpdate();
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
				JdbcConnection.removeConnection(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
				sc.close();
		}
	}

}
