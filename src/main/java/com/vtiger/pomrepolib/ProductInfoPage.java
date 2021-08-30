package com.vtiger.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
			public ProductInfoPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//span[@class='lvtHeaderText']")
			private WebElement sucessfulmsg;
			@FindBy(xpath="//td[text()='Product No']/following-sibling::td[@class='dvtCellInfo']")
			private WebElement productno;
			public WebElement getProductno() {
				return productno;
			}
			public WebElement getSucessfulmsg() {
				return sucessfulmsg;
			}
}
