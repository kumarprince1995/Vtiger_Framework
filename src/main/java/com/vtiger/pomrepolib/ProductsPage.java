package com.vtiger.pomrepolib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.genericlibraries.WebDriverUtility;

public class ProductsPage extends WebDriverUtility{
	WebDriver driver;
	public ProductsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createimgbutton;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtextfield;
	@FindBy(id="bas_searchfield")
	private WebElement indropdown;
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Product Name']")
	private WebElement productname;
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Product No']")
	private WebElement productno;
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Qty. in Stock']")
	private WebElement qualityinstock;
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Part Number']")
	private WebElement partno;
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Commission Rate']")
	private WebElement commisionrate;
	@FindBy(name="submit")
	private WebElement submitbutton;
	@FindBy(xpath="//table/tbody/tr[*]/td[contains(text(),'PRO')]")
	private List<WebElement> productnotext;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/descendant::span[@vtfieldname='product_no']/..")
	private WebElement prodnotext;
	@FindBy(xpath="//a[@alt='Next']")
	private WebElement nextListPage;

	@FindBy(name="Products_listViewCountContainerName")
	private WebElement pageCount;

	@FindBy(xpath = "//img[contains(@src,'/softed/images/status.gif')]")
	private WebElement statusBar;

	public WebElement getNextListPage() {
		return nextListPage;
	}

	public WebElement getProdnotext() {
		return prodnotext;
	}

	public List<WebElement> getProductnotext() {
		return productnotext;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}



	public WebElement getIndropdown() {
		return indropdown;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductno() {
		return productno;
	}

	public WebElement getQualityinstock() {
		return qualityinstock;
	}

	public WebElement getPartno() {
		return partno;
	}

	public WebElement getCommisionrate() {
		return commisionrate;
	}

	public WebElement getSearchimgbutton() {
		return searchtextfield;
	}

	public WebElement getCreateimgbutton() {
		return createimgbutton;
	}
	@FindBy(xpath="//a[@title='Products']")
	private WebElement productnameaftersearch;

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getProductnameaftersearch() {
		return productnameaftersearch;
	}

	public void Searchproduct(String productdata,String selectby){
		searchtextfield.sendKeys(productdata);
		select(indropdown, selectby);
		submitbutton.click();	
	}

	public boolean searchForProductId(String ProjectId) {
		Boolean flag=false;
		//get page count
		String pageNum=pageCount.getText().substring(pageCount.getText().length()-2);
		int pageCount=Integer.parseInt(pageNum.trim());
		//store all the product id from all page
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<pageCount;i++) {
			for(int j=0;j<productnotext.size();j++) {
				list.add(productnotext.get(j).getText());
				//System.out.println(productnotext.get(j).getText());
			}
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOf(statusBar));
			//click on next after selecting all the productId
			try {
				nextListPage.click();
			}
			catch (Exception e) {
				break;
			}

			wait.until(ExpectedConditions.invisibilityOf(statusBar));
		}
		//search for project id
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(ProjectId)) {
				flag=true;
				break;
			}

		}
		return flag;


	}

}
