package com.Ranfordbank.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleTNG extends BaseTNG {
		
	/*@Test
	public void Rolecreate() throws InterruptedException
	{
	Lb.Roles("Tellerabcf","Teller","E");	
	}*/

	@Test(dataProvider="Rdata")
	
	public void Rolecre(String Rname,String Rdes,String Rty) throws InterruptedException
	{
	Lb.Roles(Rname,Rdes,Rty);	
	}

		// To pass multiple data, we have to use "@DataProvider" in TestNG
	
		@DataProvider
		
		public Object[][] Rdata()
		{
			Object[][] Obj=new Object[4][3];
			
			Obj[0][0]="TellerSC01";
			Obj[0][1]="Teller";
			Obj[0][2]="E";
			
			Obj[1][0]="TellerSC02";
			Obj[1][1]="Teller";
			Obj[1][2]="E";
			
			Obj[2][0]="TellerSC03";
			Obj[2][1]="Teller";
			Obj[2][2]="E";
			
			Obj[3][0]="TellerSC04";
			Obj[3][1]="Teller";
			Obj[3][2]="E";
			
			return Obj;
		}
}
