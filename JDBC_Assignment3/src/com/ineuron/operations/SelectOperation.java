
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class SelectOperation {

	
	public static void select() {

		//Resources
		Connection connection=null;
		ResultSet resultset=null;
		PreparedStatement pstmt=null;
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			connection=JdbcConnection.getConnection();
			
			System.out.println("enter id");
			int id=sc.nextInt();
			
			String selectquery="select * from student where sid=?";
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(selectquery);
			}
			if(pstmt!=null)
			{
				pstmt.setInt(1, id);
				resultset=pstmt.executeQuery();
			}
			if(resultset!=null)
			{
				if(resultset.next())
				{
					System.out.println("SID\tSNAME\tSAGE\tSADDR");
					int sid=resultset.getInt(1);
					String name=resultset.getString(2);
					int age=resultset.getInt(3);
					String address=resultset.getString(4);
					System.out.println(sid+" \t"+name+" \t"+age+" \t"+address);
				}
				else
				{
					System.out.println("no records found for ::"+id);
				}
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
				JdbcConnection.removeConnection(resultset, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
				sc.close();
		}
	}

}
