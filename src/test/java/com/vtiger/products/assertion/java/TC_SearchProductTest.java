package com.vtiger.products.assertion.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mysql.cj.exceptions.PropertyNotModifiableException;
import com.vtiger.genericlibraries.BaseClass;
import com.vtiger.pomrepolib.CreateProductPage;
import com.vtiger.pomrepolib.HomePage;
import com.vtiger.pomrepolib.ProductInfoPage;
import com.vtiger.pomrepolib.ProductsPage;

public class TC_SearchProductTest extends BaseClass{
	@Test(groups={"smoketest"})
	public void SearchProductByproductname() throws Throwable {
	//	test= reports.createTest("SearchProductByproductname");
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateimgbutton().click();
		CreateProductPage cpp=new CreateProductPage(driver);		
		String productdata=exlib.getDataFromExcel("productData", 5, 3)+jlib.getRanDomNumber();
		cpp.createproduct(productdata);
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String sucessmsg = productinfo.getSucessfulmsg().getText();
		boolean sucessfulmsg=sucessmsg.contains(productdata);
		Assert.assertTrue(sucessfulmsg);
	}
	@Test(groups={"regressiontest"})
	public void SearchProductByproductno() throws Throwable {
	//	test= reports.createTest("SearchProductByproductno");
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateimgbutton().click();
		CreateProductPage cpp=new CreateProductPage(driver);		
		String productnamedata=exlib.getDataFromExcel("productData", 7, 3)+jlib.getRanDomNumber();
		cpp.createproduct(productnamedata);
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String sucessmsg = productinfo.getSucessfulmsg().getText();
		String productno = productinfo.getProductno().getText();
		hp.getProductslink().click();
		pp.Searchproduct(productno ,"Product No");
		weblib.waitForElementVisibility(driver, pp.getProductnameaftersearch());
		Thread.sleep(10000);
		System.out.println(pp.getProdnotext().getText());
		System.out.println(productno);
		Assert.assertEquals(productno.trim(), pp.getProdnotext().getText().trim());
	}
	@Test(groups={"regressiontest"})
	public void SearchProductBypartno() throws Throwable {
		//	test= reports.createTest("SearchProductBypartno");
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateimgbutton().click();
		CreateProductPage cpp=new CreateProductPage(driver);		
		String productnamedata=exlib.getDataFromExcel("productData", 8, 3)+jlib.getRanDomNumber();
		String partnodata=exlib.getDataFromExcel("productData", 8, 4);
		cpp.createproduct(productnamedata,partnodata,cpp.getPartnumbertextfield());
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String sucessmsg = productinfo.getSucessfulmsg().getText();
		String productno = productinfo.getProductno().getText();
		hp.getProductslink().click();
		pp.Searchproduct(partnodata ,"Part Number");
		System.out.println("product searched");
		System.out.println("created Project ID: "+productno.trim());
		Assert.assertTrue(pp.searchForProductId(productno.trim()));
		System.out.println("product searched");
	}
	@Test(groups={"regressiontest"})
	public void SearchProductbyCommisionRate() throws Throwable {
		//	test= reports.createTest("SearchProductbyCommisionRate");
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateimgbutton().click();
		CreateProductPage cpp=new CreateProductPage(driver);		
		String productnamedata=exlib.getDataFromExcel("productData", 9, 3)+jlib.getRanDomNumber();
		String commisiondata=exlib.getDataFromExcel("productData", 9, 6);
		cpp.createproduct(productnamedata,commisiondata,cpp.getCommisiontextfield());
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String sucessmsg = productinfo.getSucessfulmsg().getText();
		String productno = productinfo.getProductno().getText();
		hp.getProductslink().click();
		pp.Searchproduct(commisiondata ,"Commission Rate");
		weblib.waitForElementVisibility(driver, pp.getProductnameaftersearch());
		System.out.println(pp.getProdnotext().getText());
		Thread.sleep(3000);
		System.out.println(productno);
		System.out.println("created Project ID: "+productno.trim());
		Assert.assertTrue(pp.searchForProductId(productno.trim()));
		System.out.println("product searched");
	}
	@Test(groups={"regressiontest"})
	public void SearchProductbyQtyinstock() throws Throwable {
		//	test= reports.createTest("SearchProductbyQtyinstock");
		HomePage hp=new HomePage(driver);
	hp.getProductslink().click();
	ProductsPage pp=new ProductsPage(driver);
	pp.getCreateimgbutton().click();
	CreateProductPage cpp=new CreateProductPage(driver);		
	String productnamedata=exlib.getDataFromExcel("productData", 10, 3)+jlib.getRanDomNumber();
	String qtyinstockdata=exlib.getDataFromExcel("productData", 10, 7);
	cpp.createproduct(productnamedata,qtyinstockdata,cpp.getQtyintextfield());
	ProductInfoPage productinfo=new ProductInfoPage(driver);
	String sucessmsg = productinfo.getSucessfulmsg().getText();
	String productno = productinfo.getProductno().getText();
	hp.getProductslink().click();
	pp.Searchproduct(qtyinstockdata ,"Qty. in Stock");
	Thread.sleep(3000);
	weblib.waitForElementVisibility(driver, pp.getProductnameaftersearch());
	System.out.println(pp.getProdnotext().getText());
	System.out.println(productno);
	System.out.println("created Project ID: "+productno.trim());
	Assert.assertTrue(pp.searchForProductId(productno.trim()));
	System.out.println("product searched");
	}
	@Test(groups={"regressiontest"})
	public void SearchProductByqtybyunit() throws Throwable {
		//	test= reports.createTest("SearchProductByqtybyunit");
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateimgbutton().click();
		CreateProductPage cpp=new CreateProductPage(driver);		
		String productdata=exlib.getDataFromExcel("productData", 11, 3)+jlib.getRanDomNumber();
		String qtyperunitdata=exlib.getDataFromExcel("productData", 11, 8);
		cpp.createproduct(productdata,qtyperunitdata,cpp.getQtyinstocktextfield());
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String productno = productinfo.getProductno().getText();
		hp.getProductslink().click();
		pp.Searchproduct(qtyperunitdata ,"Qty/Unit");
		Thread.sleep(3000);
		System.out.println(pp.getProdnotext().getText());
		System.out.println(productno);
		System.out.println("created Project ID: "+productno.trim());
		Assert.assertTrue(pp.searchForProductId(productno.trim()));
		System.out.println("product searched");
	}
	@Test(groups={"regressiontest"})
	public void SearchProductByunitPriceTest() throws Throwable {
		//	test= reports.createTest("SearchProductByunitPriceTest");
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateimgbutton().click();
		CreateProductPage cpp=new CreateProductPage(driver);	
		String productdata=exlib.getDataFromExcel("productData", 12, 3)+jlib.getRanDomNumber();
		String unitpricedata=exlib.getDataFromExcel("productData", 12, 9);
		cpp.createproduct(productdata,unitpricedata,cpp.getUnitpricetextfield());
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String productno = productinfo.getProductno().getText();
		hp.getProductslink().click();
		pp.Searchproduct(unitpricedata ,"Unit Price");
		Thread.sleep(10000);
		System.out.println(pp.getProdnotext().getText());
		System.out.println(productno);
		System.out.println("created Project ID: "+productno.trim());
		Assert.assertTrue(pp.searchForProductId(productno.trim()));
		System.out.println("product searched");

	}
}
