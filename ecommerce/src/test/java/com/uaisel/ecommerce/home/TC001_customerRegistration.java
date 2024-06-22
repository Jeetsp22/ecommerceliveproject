package com.uaisel.ecommerce.home;

import org.testng.annotations.Test;

import com.uaisel.ecommerce.pageUI.CreateLoginAccounts;
import com.uaisle.ecommerce.basepage.BasePage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC001_customerRegistration extends BasePage {

	public static final Logger log = Logger.getLogger(TC001_customerRegistration.class.getName());

	@Test
	public void customerRegistration() throws Exception {
		log.info("****Starting TC001_Customer Registration****");
		CreateLoginAccounts login = new CreateLoginAccounts(driver); // Has a relation
		login.createAnAccount();
		log.info("****End TC001_Customer Registration****");
		
	}
	@Test
	public void hmsLogin() {
		System.out.println("HMSLOGIN");
		
	}
	@Test
	public void hmsLogout() {
		System.out.println("HMSLogout");
		
	}

	@BeforeClass
	public void beforeTest() throws Exception {
		browserlaunch(getData("browser"), getData("url"));
	}
	@AfterClass
	public void endTest()
	{
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}

}
