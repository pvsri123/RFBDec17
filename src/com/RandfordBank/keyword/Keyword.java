package com.RandfordBank.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword {

	public static void main(String[] args) throws IOException {
		
		KeyLib LB=new KeyLib();
		 String Res=null;
		 
		 String Kpath="C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\RandfordBank\\keyword\\keyword_data.xlsx";
		 String Kout="C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\RandfordBank\\keyword\\Res_keyword_data.xlsx";
		
		 FileInputStream fi=new FileInputStream(Kpath);
		 
		 XSSFWorkbook wb=new XSSFWorkbook(fi);

			XSSFSheet ws=wb.getSheet("TestCase");
			XSSFSheet ws1=wb.getSheet("TestSteps");
			
			//XSSFSheet ws2=wb.getSheet("TestData");
			
			int tcRc=ws.getLastRowNum();
	        System.out.println(tcRc);
	        
			int tsRc=ws1.getLastRowNum();
			System.out.println(tsRc);
			
			//test cases

			for (int i = 1; i <= tcRc; i++)
			{
				String exe=ws.getRow(i).getCell(2).getStringCellValue();
				if (exe.equalsIgnoreCase("Y"))
				{
					String tcId=ws.getRow(i).getCell(0).getStringCellValue();
				System.out.println(tcId);
				
				//test steps
					
					for (int j = 1; j <= tsRc ; j++) 
					{
						String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
						//System.out.println(tsTcid);
						if (tcId.equalsIgnoreCase(tsTcid))
						{
							String key=ws1.getRow(j).getCell(3).getStringCellValue();
							System.out.println(key);
							switch (key) 
							{
							case "rLanch":
								Res=LB.openApp("http://183.82.100.55/ranford2/home.aspx");
								break;
							case "rLogin":
								Res=LB.AdmLgn("Admin","Admin");
								break;
							case "rLogout": 	
								LB.admlgt();
								break;
							case "rBranch":
									LB.branch();
								break;
							case "rRole":
								Res=LB.Role("Cashier08","E");
								break;
							case "rClose":
								LB.Appc();
								break;
							
							default:
								System.out.println("Pass a Valid Keyword");
								break;
							}

							//result updation in test steps sheet
							
							ws1.getRow(j).createCell(4).setCellValue(Res);
							
							//result updation in test case sheet
							
							if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
							{
								ws.getRow(i).createCell(3).setCellValue(Res);
							}
							else
							{
								ws.getRow(i).createCell(3).setCellValue("Fail");
							}
													
						}
										
					}
					
				}
				else
				{
					ws.getRow(i).createCell(3).setCellValue("BLOCKED");
				}
			}
			FileOutputStream fo=new FileOutputStream(Kout);
			wb.write(fo);
			wb.close();

		}

}

