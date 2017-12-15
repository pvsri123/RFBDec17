package com.Ranfordbank.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {

	
	DesiredCapabilities cap =null;
	
	@Parameters("browser")
	@Test
	public void gd(String Br) throws MalformedURLException, InterruptedException{
		
		if(Br.equalsIgnoreCase("firefox"))
		{
		cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		}
		else if (Br.equalsIgnoreCase("chrome")) 
		{
			cap=new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);	
		}
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.14:4444/wd/hub"),cap);
		
		driver.get("http://183.82.100.55/ranford2/home.aspx");
		driver.manage().window().maximize();
		
		// For login page
		
		RanfordHP RHP = PageFactory.initElements(driver, RanfordHP.class);
		RHP.login();
		Thread.sleep(3000);
		AdminHP AHP = PageFactory.initElements(driver, AdminHP.class);
		AHP.Lout();
	}
}
