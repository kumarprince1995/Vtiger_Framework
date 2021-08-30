package com.vtiger.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericlibraries.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Products")
	private WebElement productslink;
	//@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	@FindBy(id="qccombo")
	private WebElement quickcreatelist;
	@FindBy(xpath="//option[text()='New Product']")
	private WebElement newproductdroplist;
	@FindBy(linkText="Home")
	private WebElement hometext;
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	public WebElement getContactslink() {
		return contactslink;
	}
	public WebElement getHometext() {
		return hometext;
	}
	public WebElement getQuickcreatelist() {
		return quickcreatelist;
	}
	public WebElement getNewproductdroplist() {
		return newproductdroplist;
	}
	/*Action method to signout*/
	public void SignoutfromApp() throws Throwable {
		Actions actions=new Actions(driver);
		actions.moveToElement(administratorimg).perform();
		signoutlink.click();
	}
	public WebElement getProductslink() {
		return productslink;
	}
	public WebElement getAdministratorimg() {
		return administratorimg;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	WebDriverUtility weblib=new WebDriverUtility();
	public void Selectquick(String option) {
		weblib.select(quickcreatelist, option);
	}
	

}
