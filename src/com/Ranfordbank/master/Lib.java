package com.Ranfordbank.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class Lib {
	
	public static WebDriver driver;
	public static String ExpectedVal , ActualVal,Actualval1;
	public static Properties PR;
	public static FileInputStream Fis;
	

	public String OpenApp(String Url) throws IOException
	{
				
		PR=new Properties();
		Fis=new FileInputStream("C:\\Users\\Sreenivas\\workspace\\RanfordBank\\src\\com\\Ranfordbank\\properties\\Rep.properties");
		PR.load(Fis);
		
		
		// Firefox Browser
		
				 driver = new FirefoxDriver();
				//launch Ranford bank App
				 driver.get(Url);
									
				//maximize
				driver.manage().window().maximize();
				
				String Expectedval="Ranford Bank";
				
				//get text
				
						String Actualval=driver.findElement(By.xpath(PR.getProperty("Rbank"))).getText();
						if (Expectedval.equalsIgnoreCase(Actualval))
						{
						System.out.println("Ranford Home Page is Displayed");
						return "Browser opening passed";
						}
						else
						{
							System.out.println("Ranford Home page is not Displayed");
							return "Browser opening failed";
						}
							
			}
	
	
	public String AdminLgn(String Username,String Pwd)
	{
		//Admin Login
				String Expectedval = "Welcome to Admin";
				driver.findElement(By.id(PR.getProperty("Username"))).sendKeys(Username);
				driver.findElement(By.id(PR.getProperty("Pwd"))).sendKeys(Pwd);
				driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
				
				//get text
				
				String Actualval1=driver.findElement(By.xpath(PR.getProperty("Admin"))).getText();
				if (Expectedval.equalsIgnoreCase(Actualval1))
				{
				System.out.println("Admin Page is Displayed");	
				}
				else
				{
					System.out.println("Admin Home page is not Displayed");
				}
				return "AdminSuccessful";
	}
	
	public String Branch(String BranchName,String Address1,String ZipCode, String Country,String State,String City) throws InterruptedException
	{
		
		//branches
		System.out.println(BranchName+" "+ Address1+""+ZipCode+" "+Country+""+State+""+City);
				//String Expectedval="Sucessfully";
				
				// Click on branches
				driver.findElement(By.xpath(PR.getProperty("Branch"))).click();
				
				// Click on new branches
				driver.findElement(By.xpath(PR.getProperty("BttnNewBR"))).click();
				
				//  new branch details
				
				driver.findElement(By.id(PR.getProperty("BranchName"))).sendKeys(BranchName);
				driver.findElement(By.id(PR.getProperty("Address1"))).sendKeys(Address1);
				driver.findElement(By.id(PR.getProperty("ZipCode"))).sendKeys(ZipCode);
				Sleeper.sleepTightInSeconds(5);
				
					
				//handling dropdown
				
				Select CountryDropdown =new Select(driver.findElement(By.id(PR.getProperty("Country"))));
				CountryDropdown.selectByVisibleText(Country);
				Thread.sleep(3000);
				Select StateDropdown = new Select(driver.findElement(By.xpath(PR.getProperty("State"))));
				StateDropdown.selectByVisibleText(State);
				
				Select CityDropdown = new Select(driver.findElement(By.xpath(PR.getProperty("City"))));
				CityDropdown.selectByVisibleText(City);
				
				Thread.sleep(3000);
				driver.findElement(By.id(PR.getProperty("Submit"))).click();
				
				// to handle the java script alert pop up box in selenium
							
				Alert alert = driver.switchTo().alert();
					
				//Sleeper.sleepTightInSeconds(5);
				Thread.sleep(3000);
				
				System.out.println("Alert text:"+alert.getText());
				
				alert.accept();
									
				/*
				if (Actualval1.contains(Expectedval)) 
				{
					System.out.println("Branch created");	
				
				}
				else
				{
					System.out.println("Branch already exist");
				}*/
				Home();
				return "New Branch";
				
				}
	
	public void Home(){
				
		// go to home
		
		driver.findElement(By.xpath(PR.getProperty("Home"))).click();
		Sleeper.sleepTightInSeconds(5);
	}
	
	public String Roles(String RoleName,String RoleDesc,String RoleType) throws InterruptedException
	{
		
		// go to "roles"
		
		 driver.findElement(By.xpath(PR.getProperty("Rolesbttn"))).click();
		 Sleeper.sleepTightInSeconds(5);
		 
		 Thread.sleep(3000);
		// go to  new "role"
		 
				 driver.findElement(By.id(PR.getProperty("NewRolebttn"))).click();
				 
				 driver.findElement(By.id(PR.getProperty("RoleName"))).sendKeys(RoleName);
				 driver.findElement(By.id(PR.getProperty("RoleDesc"))).sendKeys(RoleDesc);
				
				 
				Select Role = new Select(driver.findElement(By.xpath(PR.getProperty("RoleType"))));
				Role.selectByValue(RoleType);
				
				 driver.findElement(By.id(PR.getProperty("InsertNewRolebttn"))).click();
				 Sleeper.sleepTightInSeconds(5);
		 
				//alert
				 driver.switchTo().alert().accept();
				 Home();
				 return("New Role Created");
				 
			
	}

	public String Employee(String EmployeeName,String LoginPassword,String Role,String EBranch){
		
		// Employees
		
					driver.findElement(By.xpath(PR.getProperty("Empbttn"))).click();
					Sleeper.sleepTightInSeconds(5);
					// New employee
					
					driver.findElement(By.xpath(PR.getProperty("NewEmpbttn"))).click();
					driver.findElement(By.id(PR.getProperty("EmployeeName"))).sendKeys(EmployeeName);
					driver.findElement(By.id(PR.getProperty("LoginPassword"))).sendKeys(LoginPassword);
					
					
					Select EmpRole = new Select(driver.findElement(By.xpath(PR.getProperty("Role"))));
					EmpRole.selectByVisibleText(Role);
					
					Select EmpBranch = new Select(driver.findElement(By.id(PR.getProperty("EBranch"))));
					EmpBranch.selectByVisibleText(EBranch);
					
					driver.findElement(By.xpath(PR.getProperty("Empsubmit"))).click();
					Sleeper.sleepTightInSeconds(5);
					//alert
					 driver.switchTo().alert().accept();
					 Home();
					 return("New Employee");
					// Sleeper.sleepTightInSeconds(5);
				//	driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
				//	Sleeper.sleepTightInSeconds(5);
	}
	
	public void Logout(){
		
		driver.findElement(By.xpath(PR.getProperty("Logout"))).click();
	}
	
	public void AClose(){
		driver.close();
	}
}
