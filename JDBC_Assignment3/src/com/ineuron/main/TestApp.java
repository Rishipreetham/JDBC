package com.ineuron.main;

import java.util.Scanner;

import com.ineuron.operations.DeleteOperation;
import com.ineuron.operations.InsertOperation;
import com.ineuron.operations.SelectOperation;
import com.ineuron.operations.UpdateOperation;

public class TestApp {

	public void input()
	{
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("perform CRUD operation using preparedStatement\r\n"
				+ "1. insert 2. update 3. select 4. delete");
		System.out.println();
		System.out.println("enter input");
		int input=sc.nextInt();
		switch(input)
		{
		
		case 1:InsertOperation.insert();
				break;
		case 2:UpdateOperation.update();
				break;
		case 3:SelectOperation.select();
				break;
		case 4:DeleteOperation.delete();
				break;
		default:System.out.println("please enter valid input");	
			
		}
	}
	public static void main(String[] args) {

		TestApp obj = new TestApp();
		obj.input();
	}

}
