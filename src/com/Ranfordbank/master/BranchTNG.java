package com.Ranfordbank.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchTNG extends BaseTNG{
	
	/*@Test
	public void Branch() throws InterruptedException{
		Lb.Branch("Begumpet", "NearBridge", "50016","INDIA","Andhra Pradesh", "Hyderabad");
	}
*/
	
	@Test(dataProvider="Brdata")
	
	public void Branch(String BranchName,String Address1,String ZipCode, String Country,String State,String City) throws InterruptedException
	{
	 Lb.Branch(BranchName, Address1, ZipCode, Country, State, City);
	}

		// To pass multiple data, we have to use "@DataProvider" in TestNG
	
		@DataProvider
		
		public Object[][] Brdata()
		{
			Object[][] Obj2=new Object[3][6];
			
			Obj2[0][0]="Begumpet";
			Obj2[0][1]="NearTower";
			Obj2[0][2]="50016";
			Obj2[0][3]="INDIA";
			Obj2[0][4]="Andhra Pradesh";
			Obj2[0][5]="Hyderabad";
			
			Obj2[1][0]="Benz circle";
			Obj2[1][1]="NearSchool";
			Obj2[1][2]="50004";
			Obj2[1][3]="INDIA";
			Obj2[1][4]="Andhra Pradesh";
			Obj2[1][5]="Hyderabad";
			
						
			Obj2[2][0]="Adayar";
			Obj2[2][1]="NearHospital";
			Obj2[2][2]="50025";
			Obj2[2][3]="INDIA";
			Obj2[2][4]="Tamil Nadu";
			Obj2[2][5]="CHENNAI";
			
						
			return Obj2;
		}
	
	
}
