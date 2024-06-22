package com.uaisel.E_Commerce_POM.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.uaisel.E_Commerce_POM.basepage.BasePage;

public class CreateLoginAccount extends BasePage {
	//public static final Logger log=Logger.getLogger(CreateLoginAccount.class.getName());
	
	@FindBy(linkText = "Sign in") WebElement linktxtSignin;
	@FindBy(id="email_create") WebElement txtboxEmail;
	@FindBy(id="SubmitCreate") WebElement btnCreateAnAccount;
	@FindBy(xpath = "//h3[text()='Create an account']")WebElement txtCreateAnAccount;
	@FindBy(id="id_gender1") WebElement radioMr;
	@FindBy(id="customer_firstname")WebElement txtFirstName;
	@FindBy(id="customer_lastname")WebElement txtLastName;
	@FindBy(id="passwd")WebElement txtPassword;
	@FindBy(id="days")WebElement dropDownDays;
	@FindBy(id="months")WebElement dropDownMonth;
	@FindBy(id="years")WebElement dropDownYears;
	@FindBy(id="uniform-newsletter")WebElement Checkbox;
	@FindBy(id="submitAccount")WebElement btnRegister;
	@FindBy(xpath="//h1[text()='My account']")WebElement txtMyAccount;
	
	public CreateLoginAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createAccount() throws Exception {
		linktxtSignin.click();
		//log.info("Clicked on SignIN button with object:"+linktxtSignin.toString());
		txtboxEmail.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainname"));
		btnCreateAnAccount.click();
		assertEquals(txtCreateAnAccount.getText(),"CREATE AN ACCOUNT");
		Thread.sleep(8000);
		radioMr.click();
		txtFirstName.sendKeys("Mahesh");
		txtLastName.sendKeys("D");
		txtPassword.sendKeys("abc@123");
		/*new Select(dropDownDays).selectByIndex(7);
		new Select(dropDownMonth).selectByIndex(5);
		new Select(dropDownYears).selectByIndex(9);*/
		selectOption(dropDownDays, 4);
		selectOption(dropDownMonth, 11);
		selectOption(dropDownYears, 5);
		Checkbox.click();
		btnRegister.click();
		assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
		
		
	}

}
