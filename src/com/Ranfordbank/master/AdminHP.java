package com.Ranfordbank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHP {

	
	// Element properties login Admin home page
	
	@FindBy(xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
	WebElement Branch;
	@FindBy(xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
	WebElement Roles;
	@FindBy(xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
	WebElement Employee;
	@FindBy(xpath=".//*[@id='Table_02']/tbody/tr/td[3]/a/img")
	WebElement Logout;
	
	// Element properties for new branch creation
	
	@FindBy(xpath=".//*[@id='BtnNewBR']")
	WebElement BttnNewBR;
	@FindBy(id="txtbName")
	WebElement BranchName;
	@FindBy(id="txtAdd1")
	WebElement Address1;
	@FindBy(id="txtZip")
	WebElement ZipCode;
	@FindBy(id="lst_counrtyU")
	WebElement Country;
	@FindBy(xpath=".//*[@id='lst_stateI']")
	WebElement State;
	@FindBy(xpath=".//*[@id='lst_cityI']")
	WebElement City;
	@FindBy(id="btn_insert")
	WebElement Submit;
	
	
	// Element properties for new role creation
	
	@FindBy(xpath=".//*[@id='btnRoles']")
	WebElement NewRolebttn;
			
	@FindBy(id="txtRname")
	WebElement RoleName;
	@FindBy(id="txtRDesc")
	WebElement RoleDesc;
	@FindBy(xpath=".//*[@id='lstRtypeN']")
	WebElement RoleType;
	@FindBy(id="btninsert")
	WebElement InsertNewRolebttn;
	@FindBy(xpath=".//*[@id='Table_01']/tbody/tr/td[1]/a/img")
	WebElement Home;
	
	// Element properties for new employee creation
	
	@FindBy(xpath=".//*[@id='BtnNew']")
	WebElement NewEmpbttn;
	@FindBy(id="txtUname")
	WebElement EmployeeName;
	@FindBy(id="txtLpwd")
	WebElement LoginPassword;
	@FindBy(xpath=".//*[@id='lst_Roles']")
	WebElement Role;
	@FindBy(id="lst_Branch")
	WebElement EBranch;
	@FindBy(xpath=".//*[@id='BtnSubmit']")
	WebElement Empsubmit;
	
	//Element methods
	
		
	public void Br() throws InterruptedException 
	{
		Branch.click();
				
		BttnNewBR.click();
		BranchName.sendKeys("TempleRoad");
		Address1.sendKeys("NearHighSchool");
		ZipCode.sendKeys("50004");
		Country.sendKeys("INDIA");
		Thread.sleep(3000);
		State.sendKeys("Andhra Pradesh");
		City.sendKeys("Hyderabad");
		Submit.click();
	}
	
	public void Rl()
	{
		Roles.click();
				
	}
	
	public void NewRoleCreate() throws InterruptedException{
		NewRolebttn.click();
		RoleName.sendKeys("Teller");
		RoleDesc.sendKeys("Cashdistribution");
		RoleType.sendKeys("E");
		Thread.sleep(3000);
		InsertNewRolebttn.click();

	}
	
	public void HPage()
	{
		
		Home.click();
		
	}
		
	public void Emp(){
		
		Employee.click();
		NewEmpbttn.click();
		EmployeeName.sendKeys("Sharma");
		LoginPassword.sendKeys("TRUMP");
		Role.sendKeys("Manager");
		EBranch.sendKeys("Begumpet");
		Empsubmit.click();
		
	}
	
	public void Lout()
	{
		Logout.click();
		
	}
}

