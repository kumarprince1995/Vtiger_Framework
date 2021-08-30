package com.vtiger.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="productname")
	private WebElement orgname;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	@FindBy(xpath="//span[text()='Creating New Product']")
	private WebElement createnewproducttext;
	@FindBy(id="productcode")
	private WebElement partnumbertextfield;
	@FindBy(id="commissionrate")
	private WebElement commisiontextfield;
	@FindBy(id="qtyinstock")
	private WebElement qtyintextfield;
	@FindBy(id="qty_per_unit")
	private WebElement qtyperunittextfield;
	@FindBy(id="unit_price")
	private WebElement unitpricetextfield;
	public WebElement getQtyinstocktextfield() {
		return qtyperunittextfield;
	}
	public WebElement getUnitpricetextfield() {
		return unitpricetextfield;
	}
	public WebElement getQtyintextfield() {
		return qtyintextfield;
	}
	public WebElement getCommisiontextfield() {
		return commisiontextfield;
	}
	public WebElement getPartnumbertextfield() {
		return partnumbertextfield;
	}
	public WebElement getCreatenewproducttext() {
		return createnewproducttext;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public void createproduct(String productname) {
		orgname.sendKeys(productname);
		savebutton.click();
	}
	public void createproduct(String productname ,String partno,WebElement ele) {
		orgname.sendKeys(productname);
		ele.sendKeys(partno);
		savebutton.click();
	}

}
