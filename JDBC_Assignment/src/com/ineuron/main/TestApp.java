package com.ineuron.main;

import java.util.Scanner;

import com.ineuron.operations.CreateOperation;
import com.ineuron.operations.DeleteOperation;
import com.ineuron.operations.InsertOperation;
import com.ineuron.operations.UpdateOperation;

public class TestApp {

	public void input()
	{
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter as  per the operation listed below on student table\r\n"
				+ "1. Create 2. Read 3. Update 4. Delete");
		System.out.println();
		System.out.println("enter input");
		int input=sc.nextInt();
		switch(input)
		{
		case 1:CreateOperation.create();
				break;
		case 2:InsertOperation.insert();
				break;
		case 3:UpdateOperation.update();
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
