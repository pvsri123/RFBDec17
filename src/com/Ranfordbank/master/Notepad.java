package com.Ranfordbank.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		Lib Lb = new Lib();
		String Res = Lb.OpenApp("http://183.82.100.55/ranford2/home.aspx");
		System.out.println(Res);
		Lb.AdminLgn("Admin","Admin");
		
		
		//To get Text data file path
		
		String Fpath ="C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\testdata\\Role.txt";
	
		//Results file path
				
		String Rpath="C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\results\\Res_role.txt";
	
		String SD;
				
		//To Get Text File
				
		FileReader FR=new FileReader(Fpath);
		BufferedReader BR=new BufferedReader(FR);
		String Sread=BR.readLine();
		System.out.println(Sread);
				
		//To write
				
		FileWriter FW=new FileWriter(Rpath);
		BufferedWriter BW=new BufferedWriter(FW);
		BW.write(Sread);
		BW.newLine();
				
					
		//Multiple iterations ---Conditional loop(While loop)
				
				while ((SD=BR.readLine())!=null) 
				{
					System.out.println(SD);
					
					String SR[]=SD.split("###");
					
					String RoleName=SR[0];
					String RoleDesc=SR[1];
					String RoleType=SR[2];
					
					Res=Lb.Roles(RoleName,RoleDesc,RoleType);
					System.out.println(Res);

					
			//To write into Results file

				BW.write(SD+"&&&"+Res);
				BW.newLine();
				Lb.Home();
				}
												
				BW.close();
				BR.close();
				
				Lb.Logout();
	}

}
