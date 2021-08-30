package com.vtiger.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastname;
	@FindBy(xpath="//input[@type='file']")
	private WebElement choosefile;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getChoosefile() {
		return choosefile;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
}
