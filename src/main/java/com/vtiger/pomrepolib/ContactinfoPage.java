package com.vtiger.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinfoPage {
	public ContactinfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Contact Image']")
	private WebElement contactimg;
	public WebElement getContactimg() {
		return contactimg;
	}
}
