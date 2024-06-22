package com.uaisel.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uaisle.ecommerce.basepage.BasePage;

public class CreateLoginAccounts extends BasePage {
	public static final Logger log = Logger.getLogger(CreateLoginAccounts.class.getName());

	@FindBy(linkText = "Sign in")
	WebElement textSignIN;
	@FindBy(id = "email_create")
	WebElement txtEmailID;
	@FindBy(id = "SubmitCreate")
	WebElement btnCreateAnAccount;
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement txtCreateAnAccount;
	@FindBy(id = "id_gender1")
	WebElement radioMr;
	@FindBy(id = "customer_firstname")
	WebElement txtFirstName;
	@FindBy(id = "customer_lastname")
	WebElement txtLastName;
	@FindBy(id = "passwd")
	WebElement txtPassword;
	@FindBy(id = "days")
	WebElement dropDownDays;
	@FindBy(id = "months")
	WebElement dropDownMonth;
	@FindBy(id = "years")
	WebElement dropDownYears;
	@FindBy(id = "submitAccount")
	WebElement btnRegister;
	@FindBy(xpath = "//h1[text()='My account']")
	WebElement txtMyAccount;

	public CreateLoginAccounts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createAnAccount() throws Exception {
		textSignIN.click();
		log.info("Clicked on SignIN button with object:" + textSignIN.toString());
		txtEmailID.sendKeys(getData("firstname") + getData("lastname") + randomNumber() + getData("domainname"));
		log.info("Entering Email ID :" + txtEmailID.getAttribute("value") + " using object" + txtEmailID.toString());
		btnCreateAnAccount.click();
		log.info("Clicking on Create an account: " + btnCreateAnAccount.toString());
		Thread.sleep(5000);
		assertEquals(txtCreateAnAccount.getText(), "CREATE AN ACCOUNT");
		log.info("Verifying customer info page by using object:" + txtCreateAnAccount.toString());
		radioMr.click();
		log.info("Clicking on Mr Radio button by using object: " + radioMr.toString());
        txtFirstName.sendKeys("Mahesh");
		log.info("Entering first name by using object :" + txtFirstName.toString());
		txtLastName.sendKeys("D");
		log.info("Entering last name by using object :" + txtLastName.toString());
		txtPassword.sendKeys("abc@123");
		log.info("Entering password by using object :" + txtPassword.toString());
		selectOption(dropDownDays, 4);
		log.info("Selected a day by using object :" + dropDownDays.toString());
		selectOption(dropDownMonth, 5);
		log.info("Selected a month by using object :" + dropDownMonth.toString());
		selectOption(dropDownYears, 10);
		log.info("Selected a year by using object :" + dropDownYears.toString());
		btnRegister.click();
		log.info("Clicking on Register :" + btnRegister.toString());
		Thread.sleep(5000);
		assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
		log.info("Verified My account page by using object :" + txtMyAccount.toString());
	}

}
