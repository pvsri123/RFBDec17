package com.Ranfordbank.master;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class BaseTNG {
  
	Lib Lb = new Lib();
	
  @BeforeTest
  public void beforeTest() {
	  Lb.AdminLgn("Admin", "Admin");
  }

  @AfterTest
  public void afterTest() {
	  Lb.Logout();
  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  
	  Lb.OpenApp("http://183.82.100.55/ranford2/home.aspx");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  Lb.AClose();
	  
  }

}
