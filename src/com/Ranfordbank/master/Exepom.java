package com.Ranfordbank.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Exepom {
	
	@Test
	public void pom() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://183.82.100.55/ranford2/home.aspx");
		driver.manage().window().maximize();
		
		// For login page
		
		RanfordHP RHP = PageFactory.initElements(driver, RanfordHP.class);
		RHP.login();
		
				
		AdminHP AHP = PageFactory.initElements(driver, AdminHP.class);
		
		// For Branch Creation
		AHP.Br();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();		
		Thread.sleep(3000);
		AHP.HPage();
		
		// For Role creation
		AHP.Rl();
		Thread.sleep(3000);
		AHP.NewRoleCreate();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();		
		Thread.sleep(3000);
		
		AHP.HPage();
		
		// For employee creation
		
		AHP.Emp();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		AHP.HPage();
				
		AHP.Lout();
		
	}
	
}
