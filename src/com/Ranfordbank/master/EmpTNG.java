package com.Ranfordbank.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmpTNG extends BaseTNG {
	
	
	/*@Test
	public void Empcreate() 
	{
		
		Lb.Employee("Sreenivas","James","Manager","Begumpet");
	}*/

	@Test(dataProvider="Empdata")
	
	public void Empcreate(String EmployeeName,String LoginPassword,String Role,String EBranch) throws InterruptedException
	{
	 Lb.Employee(EmployeeName,LoginPassword,Role,EBranch);
	}

		// To pass multiple data, we have to use "@DataProvider" in TestNG
	
		@DataProvider
		
		public Object[][] Empdata()
		{
			Object[][] Obj1=new Object[5][4];
			
			Obj1[0][0]="Jame";
			Obj1[0][1]="Sree";
			Obj1[0][2]="Teller";
			Obj1[0][3]="Begumpet";
			
			Obj1[1][0]="Scott";
			Obj1[1][1]="Rama";
			Obj1[1][2]="Manager";
			Obj1[1][3]="Benz circle";
			
			Obj1[2][0]="Pavan";
			Obj1[2][1]="logic";
			Obj1[2][2]="Manager";
			Obj1[2][3]="Bangalore";
			
			Obj1[3][0]="MMKrish";
			Obj1[3][1]="balakrishna";
			Obj1[3][2]="banker";
			Obj1[3][3]="Benz circle";
			
			Obj1[4][0]="Chris";
			Obj1[4][1]="magic";
			Obj1[4][2]="Teller";
			Obj1[4][3]="Adayar";
			return Obj1;
		}
	
}
