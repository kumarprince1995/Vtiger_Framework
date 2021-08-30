package com.vtiger.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickProductCreatepage {
	public QuickProductCreatepage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(name="productname")
	private WebElement orgname;
	@FindBy(xpath="//input[@value='U']")
	private WebElement userchkbox;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupchkbox;
	@FindBy(xpath="//option[text()='Marketing Group']")
	private WebElement marketinggroup;
	@FindBy(xpath="//option[text()='Support Group']")
	private WebElement SupportGroup;
	@FindBy(xpath="//option[text()='Team Selling']")
	private WebElement TeamSelling;
	public WebElement getMarketinggroup() {
		return marketinggroup;
	}

	public WebElement getSupportGroup() {
		return SupportGroup;
	}

	public WebElement getTeamSelling() {
		return TeamSelling;
	}

	public WebElement getOrgname() {
		return orgname;
	}
	
	public WebElement getUserchkbox() {
		return userchkbox;
	}

	public WebElement getGroupchkbox() {
		return groupchkbox;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	public void createproduct(String productname) {
		orgname.sendKeys(productname);
		userchkbox.click();
		savebutton.click();
	}
	public void createproduct(String productname,WebElement ele) {
		orgname.sendKeys(productname);
		groupchkbox.click();
		ele.click();
		savebutton.click();
	}

}
