//perform insertion operation and also perform retrieval operation on the following
//data
//name =>
//address=>
//gender =>
//DOB => dd-MM-yyyy
//DOJ => MM-dd-yyyy
//DOM => yyyy-MM-dd

package com.ineuron.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.ineuron.util.JdbcConnection;

public class TestApp {

	public static void main(String[] args) {

		//Resources
		Connection connection=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet resultset=null;
		Scanner sc = new Scanner(System.in);
		
		try
		{
			connection=JdbcConnection.getConnection();
			
			System.out.println("enter name");
			String name=sc.next();
			
			System.out.println("enter address");
			String address=sc.next();
			
			System.out.println("enter gender");
			String gender=sc.next();
			
			System.out.println("enter DOB(dd-MM-yyyy)");
			String DOB=sc.next();
			
			System.out.println("enter DOJ(MM-dd-yyyy)");
			String DOJ=sc.next();
			
			System.out.println("enter DOM(yyyy-MM-dd)");
			String DOM=sc.next();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date Udate=sdf.parse(DOB);
			java.sql.Date Sdate= new java.sql.Date(Udate.getTime());
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date Udate1=sdf1.parse(DOJ);
			java.sql.Date Sdate1= new java.sql.Date(Udate1.getTime());
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date Udate2=sdf2.parse(DOM);
			java.sql.Date Sdate2= new java.sql.Date(Udate2.getTime());
			
			//Query
			String insertQuery="insert into user values(?,?,?,?,?,?)";
			String selectQuery="select * from user where name=?";

			if(connection!=null)
			{
				pstmt=connection.prepareStatement(insertQuery);
				pstmt1=connection.prepareStatement(selectQuery);
			}
			
			if(pstmt!=null)
			{
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, gender);
				pstmt.setDate(4, Sdate);
				pstmt.setDate(5, Sdate1);
				pstmt.setDate(6, Sdate2);

				int noofrows=pstmt.executeUpdate();
				System.out.println("No of rows inserted are ::"+noofrows);
			}
			System.out.println();
			System.out.println();
			if(pstmt1!=null)
			{
				pstmt1.setString(1, name);
				resultset=pstmt1.executeQuery();
			}
			
			if(resultset!=null)
			{
				if(resultset.next())
				{
					String username=resultset.getString(1);
					String useraddress=resultset.getString(2);
					String usergender=resultset.getString(3);
					Date userDOB=resultset.getDate(4);
					Date userDOJ=resultset.getDate(5);
					Date userDOM=resultset.getDate(6);
					
					SimpleDateFormat Sdf = new SimpleDateFormat("dd-MM-yyyy");
					String DOB1=Sdf.format(userDOB);
					String DOJ1=Sdf.format(userDOJ);
					String DOM1=Sdf.format(userDOM);
					
					System.out.println("NAME\tADDRESS\tGENDER\tDOB\tDOJ\tDOM");
					System.out.println(username+" \t "+useraddress+" \t "+usergender+" \t "+DOB1+" \t "+DOJ1+" \t "+DOM1);
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
				JdbcConnection.removeConnection(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null)
			{
				sc.close();
			}
		}
	}

}
