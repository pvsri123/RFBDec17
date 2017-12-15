package com.Ranfordbank.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basicscript {

	public static void main(String[] args) throws InterruptedException {
		
		
		// Firefox Browser
		
		WebDriver driver = new FirefoxDriver();
		//launch Ranford bank App
		driver.get("http://183.82.100.55/ranford2/home.aspx");
		
		//maximize
		driver.manage().window().maximize();
		
		String Expectedval="Ranford Bank";
		
		//get text
		
				String Actualval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
				if (Expectedval.equalsIgnoreCase(Actualval))
				{
				System.out.println("Ranford Home Page is Displayed");	
				}
				else
				{
					System.out.println("Ranford Home page is not Displayed");
				}
		//Admin Login
		Expectedval = "Welcome to Admin";
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.xpath(".//*[@id='login']")).click();
		
		//get text
		
		String Actualval1=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		if (Expectedval.equalsIgnoreCase(Actualval1))
		{
		System.out.println("Admin Page is Displayed");	
		}
		else
		{
			System.out.println("Admin Home page is not Displayed");
		}
		
		//branches
		
		Expectedval="Sucessfully";
		
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys("Kushaiguda");
		driver.findElement(By.id("txtAdd1")).sendKeys("NearECIL");
		driver.findElement(By.id("txtZip")).sendKeys("50060");
		
		
			
		//handling dropdown
		
		Select CountryDropdown =new Select(driver.findElement(By.id("lst_counrtyU")));
		CountryDropdown.selectByVisibleText("INDIA");
		Thread.sleep(3000);
		Select StateDropdown = new Select(driver.findElement(By.id("lst_stateI")));
		StateDropdown.selectByVisibleText("Andhra Pradesh");
		
		Select CityDropdown = new Select(driver.findElement(By.id("lst_cityI")));
		CityDropdown.selectByVisibleText("Hyderabad");
		
		driver.findElement(By.id("btn_insert")).click();
		
		// to handle the java script alert pop up box in selenium
					
		Alert alert = driver.switchTo().alert();
			
		Thread.sleep(3000);
		System.out.println("Alert text:"+alert.getText());
		alert.accept();
							
		
		if (Actualval.contains(Expectedval)) 
		{
		System.out.println("Branch created");	
		
		}
		else
		{
			System.out.println("Branch already exist");
		}
		
		// go to home
		
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
		
		// go to "roles"
		
		 driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		 
		 // go to  new "role"
		 
		 driver.findElement(By.id("btnRoles")).click();
		 
		 driver.findElement(By.id("txtRname")).sendKeys("Teller");
		 driver.findElement(By.id("txtRDesc")).sendKeys("Cashdistribution");
		
		 
		Select Role = new Select(driver.findElement(By.xpath(".//*[@id='lstRtypeN']")));
		Role.selectByValue("E");
		
		 driver.findElement(By.id("btninsert")).click();
		 Thread.sleep(2000);
		 
		 //alert
		 driver.switchTo().alert().accept();
		 
		// go to home
			
			driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
			
			// Employees
			
			driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
			
			// New employee
			
			driver.findElement(By.xpath(".//*[@id='BtnNew']")).click();
			driver.findElement(By.id("txtUname")).sendKeys("Shraddha");
			driver.findElement(By.id("txtLpwd")).sendKeys("world");
			
			
			Select EmpRole = new Select(driver.findElement(By.xpath(".//*[@id='lst_Roles']")));
			EmpRole.selectByVisibleText("Manager");
			
			Select EmpBranch = new Select(driver.findElement(By.id("lst_Branch")));
			EmpBranch.selectByVisibleText("Bangalore");
			
			driver.findElement(By.xpath(".//*[@id='BtnSubmit']")).click();
			
			//alert
			 driver.switchTo().alert().accept();
			 
			 
			// go to home
				
				driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
				// Logout
				
				driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
	}
	
	
	
}
