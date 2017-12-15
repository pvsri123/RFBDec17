package com.Ranfordbank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHP {

	// Element properties for home page login 
	
	@FindBy(id="txtuId")
	WebElement Username;
	@FindBy(id="txtPword")
	WebElement Pwd;
	@FindBy(xpath=".//*[@id='login']")
	WebElement Lgn;
	
	// Element Methods
	
	public void login(){
		
		Username.sendKeys("Admin");
		Pwd.sendKeys("Admin");
		Lgn.click();
	}
}
