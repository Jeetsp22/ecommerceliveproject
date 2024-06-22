package com.uaisel.E_Commerce_POM.home;

import org.testng.annotations.Test;

import com.uaisel.E_Commerce_POM.basepage.BasePage;
import com.uaisel.E_Commerce_POM.pageUI.CreateLoginAccount;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC001_CustomerRegistration extends BasePage {
	public static final Logger log=Logger.getLogger(TC001_CustomerRegistration.class.getName());
	
	
	
	@Test
	public void customerRegistration() throws Exception {
		//log.info("****Starting TC001_Customer Registrtion****");
		CreateLoginAccount login = new CreateLoginAccount(driver);
		login.createAccount();
		//log.info("****End Of TC001_Customer Registrtion****");
		
	}
	@Test
	public void hmsLogin() {
		System.out.println("HMS Login");
	}
	@Test
	public void hmsLogout() {
		System.out.println("HMS Logout");
	}

	@BeforeClass
	public void beforeTest() throws Exception {
		browserlaunch(getData("browser"),getData("URL"));  //getdata is step 2
		PropertyConfigurator.configure(log4jpath);
	}
	@AfterClass
	public void endTest() {
		closeBrowser();
	}
	public  void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
		
	}


	

	

}
