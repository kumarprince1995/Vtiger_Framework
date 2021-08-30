 package com.vtiger.products.assertion.java;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibraries.BaseClass;
import com.vtiger.pomrepolib.CreateProductPage;
import com.vtiger.pomrepolib.HomePage;
import com.vtiger.pomrepolib.ProductInfoPage;
import com.vtiger.pomrepolib.ProductsPage;

@Listeners(com.vtiger.genericlibraries.ListImplementation.class)
public class TC_CreateByProductLinkTest extends BaseClass{
	@Test(groups={"smoketest"})
	public void Createproductbyproductlink() throws Throwable {
	//	test= reports.createTest("Createproductbyproductlink");
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
		//Assert.fail();
		
	}

}
