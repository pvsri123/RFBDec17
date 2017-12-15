package com.Ranfordbank.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class Exelib {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Lib Lb = new Lib();
		String Res =Lb.OpenApp("http://183.82.100.55/ranford2/home.aspx");
		System.out.println(Res);
		Lb.AdminLgn("Admin","Admin");
		Lb.Branch("Kushaiguda","NearECIL","50060","INDIA","Andhra Pradesh","Hyderabad");
		Thread.sleep(3000);
	//	Lb.Home();

		
		// Data driven frame work
		// To get test excel data file, and creating new branches
		
		FileInputStream NbrFis = new FileInputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\testdata\\NewBranches.xlsx");
		
		// Workbook
		XSSFWorkbook NbrWB= new XSSFWorkbook(NbrFis);
		
		// Worksheet
		
		XSSFSheet NbrWS = NbrWB.getSheet("Bdata");
		
		//Rowcount
		
				int NbrRc=NbrWS.getLastRowNum();
				System.out.println(NbrRc);
				
				//multiple iterations----------For loop
				
				for (int i=1;i<=NbrRc;i++) 
				{
					//Row
					
					XSSFRow NbrWR=NbrWS.getRow(i);
					
					//Cell
					
					XSSFCell WC=NbrWR.getCell(0);
					XSSFCell WC1=NbrWR.getCell(1);
					XSSFCell WC2=NbrWR.getCell(2);
					XSSFCell WC3=NbrWR.getCell(3);
					XSSFCell WC4=NbrWR.getCell(4);
					XSSFCell WC5=NbrWR.getCell(5);
					XSSFCell WC6=NbrWR.createCell(6);
					
					//Cell values
					
	String BranchName=WC.getStringCellValue();
	String Address1=WC1.getStringCellValue();
	System.out.println(Address1);
	String ZipCode=  Integer.toString((int)WC2.getNumericCellValue());
	System.out.println(ZipCode);
	Thread.sleep(3000);
	String Country=WC3.getStringCellValue();
	
	System.out.println(Country);
	
	
 	//System.out.println("Country celltype"+ WC3.getRichStringCellValue() );
	 String State=WC4.getStringCellValue();
	 System.out.println(State);
	 String City=WC5.getStringCellValue();	
	System.out.println(City);
	
	Res = Lb.Branch(BranchName,Address1,ZipCode,Country,State,City);
	System.out.println(Res);
				    
				    WC6.setCellValue(Res);
		//		  Lb.Home();
					
				}
				
				FileOutputStream NbrFos=new FileOutputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\results\\Res_Branches.xlsx");
				NbrWB.write(NbrFos);
				NbrWB.close();
		
	
				
				// To get test excel data file, and creating new roles
				
				FileInputStream NrFis = new FileInputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\testdata\\Role.xlsx");
				
				// Workbook
				XSSFWorkbook NrWB= new XSSFWorkbook(NrFis);
				
				
				// Worksheet
				
				XSSFSheet NrWS = NrWB.getSheet("Rdata");
				
				//Rowcount
				
						int NrRc=NrWS.getLastRowNum();
						System.out.println(NrRc);
						
						//multiple iterations----------For loop
						
						for (int i=1;i<=NrRc;i++) 
						{
							//Row
							
							XSSFRow NrWR=NrWS.getRow(i);
							
							//Cell
							
							XSSFCell WC=NrWR.getCell(0);
							XSSFCell WC1=NrWR.getCell(1);
							XSSFCell WC2=NrWR.getCell(2);
							XSSFCell WC3=NrWR.createCell(3);
							
							//Cell values
							
							String RoleName=WC.getStringCellValue();
							String RoleDesc=WC1.getStringCellValue();
							String RoleType=WC2.getStringCellValue();
							
							Res=Lb.Roles(RoleName,RoleDesc,RoleType);
						    System.out.println(Res);
						    
						    WC3.setCellValue(Res);
					//	    Lb.Home();
							
						}
						
						FileOutputStream NrFos=new FileOutputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\results\\Res_Role.xlsx");
						NrWB.write(NrFos);
						NrWB.close();
							
		
				
				
	//	Lb.Roles("Teller","Cashdistribution","E");
		
	//	Lb.Employee("Shraddha","world","Manager","Bangalore");
		
		
		// To get test excel data file, and creating new employee
		
				FileInputStream EmpFis = new FileInputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\testdata\\NewEmployees.xlsx");
				
				// Workbook
				XSSFWorkbook EmpWB= new XSSFWorkbook(EmpFis);
				
				
				// Worksheet
				
				XSSFSheet EmpWS = EmpWB.getSheet("NEmp");
				
				//Rowcount
				
						int EmpRc=EmpWS .getLastRowNum();
						System.out.println(EmpRc);
						
						//multiple iterations----------For loop
						
						for (int i=1;i<=EmpRc;i++) 
						{
							//Row
							
							XSSFRow EmpWR=EmpWS.getRow(i);
							
							//Cell
							
							XSSFCell WC=EmpWR.getCell(0);
							XSSFCell WC1=EmpWR.getCell(1);
							XSSFCell WC2=EmpWR.getCell(2);
							XSSFCell WC3=EmpWR.getCell(3);
							XSSFCell WC4=EmpWR.createCell(4);
							
							//Cell values
							
							String EmployeeName=WC.getStringCellValue();
							String LoginPassword=WC1.getStringCellValue();
							String Role=WC2.getStringCellValue();
							String Branch= WC3.getStringCellValue();

							
			Res=Lb.Employee(EmployeeName,LoginPassword,Role,Branch); 
			System.out.println(Res);
						    
			WC4.setCellValue(Res);
		//	Lb.Home();
							
				}
						
		FileOutputStream EmpFos=new FileOutputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\results\\Res_NewEmployees.xlsx");
		EmpWB.write(EmpFos);
		EmpWB.close();
									
						
		Lb.Logout();
	}
}
