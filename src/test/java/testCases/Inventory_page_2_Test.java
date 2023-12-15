package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Inventory_page_2_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2(); 
		login.loginToApplication();
		
	}
	@Test (priority=1, enabled=true,groups = "Sanity")
	public void verifyproductsLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0, 3); //Products(0,3)
		String actLable=invent.verifyproductsLable();
		Assert.assertEquals(expLable,actLable); 
		Reporter.log("Lable of Inventory Page = " + actLable);
	}
	@Test(priority=5, enabled=true,groups = "Retesting")
	public void verifytwitterLogoTest()
	{
		boolean result=invent.verifytwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Visibility of Twitter Logo = " + result);
	}
	@Test(priority=2, enabled=true,groups = {"Retesting","Regression"})
	public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 4);//6(0,4)
		String actCount=invent.add6Products(); 
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products added to cart = " + actCount);
	}
	@Test(priority=4, enabled=true,groups = {"Retesting","Regression"})
	public void remove2Products() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		String expCount=ReadData.readExcel(0, 5);//4(0,5)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Count of product after removing " + actCount);
	}
	@Test(priority=3, enabled=true)
	public void clickCartTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expURL=ReadData.readExcel(0, 8);
		String actURL=invent.clickCart();
	    Assert.assertEquals(expURL, actURL);
	    Reporter.log(actURL);
	}
	
	@AfterMethod(alwaysRun = true) 
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}
			driver.close();
	}
}

