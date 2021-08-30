package com.vtiger.genericlibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vtiger.pomrepolib.HomePage;
import com.vtiger.pomrepolib.LoginPage;

public class BaseClass {
	public WebDriver driver;
//	public ExtentHtmlReporter reporter;
//	public ExtentReports reports;
//	public ExtentTest test;
//	
		
		public  ExcelUtility exlib= new ExcelUtility();
		public JavaUtility jlib=new JavaUtility();
		public FileUtility flib=new FileUtility();
		public WebDriverUtility weblib= new WebDriverUtility();
		public static WebDriver sdriver;
		//public HomePage hp=new HomePage(driver);
		@BeforeSuite(groups={"smoketest","regressiontest"})
		public void ConfigureBS() {
//			reporter= new ExtentHtmlReporter("./Vtiger/ExtendReport/Tester.html");
//		reporter.config().setDocumentTitle("Vtiger");
//			reports=new ExtentReports();
//			reports.attachReporter(reporter);
		}
		//@Parameters("BROWSER")
		 @BeforeClass(groups={"smoketest","regressiontest"})
			//public void ConfigureBC(String BROWSER) throws Throwable { 
		 public void ConfigureBC() throws Throwable { 
			String BROWSER=flib.getPropertyKeyValue("browser");
			 if(BROWSER.equals("chrome")) {
					driver=new ChromeDriver();
				}
				else if(BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("ie")) {
					driver=new InternetExplorerDriver();
				}
				else if(BROWSER.equals("opera")) {
					driver=new OperaDriver();
				}
			 //driver= new ChromeDriver();
			 sdriver=driver;
			 driver.manage().window().maximize();
			weblib.waitUntilPageLoad(driver);
	}
		 @BeforeMethod(groups={"smoketest","regressiontest"})
		 public void ConfigureBM() throws Throwable {
				
				String URL=flib.getPropertyKeyValue("url");
				String USERNAME=flib.getPropertyKeyValue("username");
				String PASSWORD=flib.getPropertyKeyValue("password");
				driver.get(URL);
				LoginPage lp=new LoginPage(driver);
				lp.login(USERNAME, PASSWORD);
						
		 }
		 @AfterMethod(groups={"smoketest","regressiontest"})
		 public void ConfigureAM() throws Throwable {
			 HomePage hp=new HomePage(driver);
			 hp.SignoutfromApp();
			 
		 }
		 @AfterClass(groups={"smoketest","regressiontest"})
		 public void ConfigureAC() {
			 driver.quit();
		 }
		 @AfterSuite
		 public void ConfigureAS() {
			 System.out.println("DisConnected to Databasxe");
			// reports.flush();
		 }

}
