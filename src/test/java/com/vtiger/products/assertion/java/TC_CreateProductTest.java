package com.vtiger.products.assertion.java;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericlibraries.BaseClass;
import com.vtiger.pomrepolib.HomePage;
import com.vtiger.pomrepolib.ProductInfoPage;
import com.vtiger.pomrepolib.QuickProductCreatepage;

public class TC_CreateProductTest  extends BaseClass{
	
		@Test
		public void Create_Product_With_Quick_CreateTest() throws Throwable {
			//	test= reports.createTest("Create_Product_With_Quick_CreateTest");
			HomePage hp=new HomePage(driver);
			hp.Selectquick("New Product");
			String productdata=exlib.getDataFromExcel("productData", 1, 3)+jlib.getRanDomNumber();
			QuickProductCreatepage qpcp=new QuickProductCreatepage(driver);
			qpcp.createproduct(productdata);
			ProductInfoPage productinfo=new ProductInfoPage(driver);
			String sucessmsg = productinfo.getSucessfulmsg().getText();
			boolean sucessfulmsg=sucessmsg.contains(productdata);
			Assert.assertTrue(sucessfulmsg);		
		}
		
		@Test
		public void Create_Product_With_Marketing_group() throws Throwable {
			//	test= reports.createTest("Create_Product_With_Marketing_group");
			HomePage hp=new HomePage(driver);
			hp.Selectquick("New Product");
			String productdata=exlib.getDataFromExcel("productData", 2, 3)+jlib.getRanDomNumber();
			QuickProductCreatepage qpcp=new QuickProductCreatepage(driver);
			qpcp.createproduct(productdata, qpcp.getMarketinggroup());
			ProductInfoPage productinfo=new ProductInfoPage(driver);
			String sucessmsg = productinfo.getSucessfulmsg().getText();
			boolean sucessfulmsg=sucessmsg.contains(productdata);
			Assert.assertTrue(sucessfulmsg);
		}
		@Test
		public void Create_Product_With_Support_group() throws Throwable{
			//		test= reports.createTest("Create_Product_With_Support_group");
			HomePage hp=new HomePage(driver);
			hp.Selectquick("New Product");
			String productdata=exlib.getDataFromExcel("productData", 3, 3)+jlib.getRanDomNumber();
			QuickProductCreatepage qpcp=new QuickProductCreatepage(driver);
			qpcp.createproduct(productdata, qpcp.getSupportGroup());
			ProductInfoPage productinfo=new ProductInfoPage(driver);
			String sucessmsg = productinfo.getSucessfulmsg().getText();
			boolean sucessfulmsg=sucessmsg.contains(productdata);
			Assert.assertTrue(sucessfulmsg);

		}
		@Test
		public void Create_Product_With_TeamSelling_group() throws Throwable{
			//	test= reports.createTest("Create_Product_With_TeamSelling_group");
		HomePage hp=new HomePage(driver);
		hp.Selectquick("New Product");
		String productdata=exlib.getDataFromExcel("productData", 4, 3)+jlib.getRanDomNumber();
		QuickProductCreatepage qpcp=new QuickProductCreatepage(driver);
		qpcp.createproduct(productdata, qpcp.getTeamSelling());
		ProductInfoPage productinfo=new ProductInfoPage(driver);
		String sucessmsg = productinfo.getSucessfulmsg().getText();
		boolean sucessfulmsg=sucessmsg.contains(productdata);
		Assert.assertTrue(sucessfulmsg);

		}
}
