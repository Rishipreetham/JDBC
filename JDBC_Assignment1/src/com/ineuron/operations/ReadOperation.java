
package com.ineuron.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class ReadOperation {

	public static void read() {

		//Resources
		Connection connection=null;
		ResultSet resultset=null;
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
			
			String selectquery=String.format("select * from student where sid=%d", id);
			if(stmt!=null)
			{
				resultset=stmt.executeQuery(selectquery);
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
				JdbcConnection.removeConnection(resultset, stmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
				sc.close();
		}
	}

}
