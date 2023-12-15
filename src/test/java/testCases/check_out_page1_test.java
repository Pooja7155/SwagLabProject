package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Check_Out_Page1;
import pages.Inventory_page_2;
import pages.LoginPage;
import pages.cartPage;
import utility.CaptureScreenshot;

public class check_out_page1_test extends TestBase
{
	

	LoginPage login;
	Inventory_page_2 invent;
	cartPage cart;
	Check_Out_Page1 check1;
   @BeforeMethod(alwaysRun = true)
   public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart=new cartPage();
		check1=new Check_Out_Page1();
		login.loginToApplication();
		invent.add6Products();
		invent.clickCart();
		cart.clickOnCheckOutBtn();
		
		
		
		
		
	}
@Test(priority=7, enabled=true)
public void InputInformationCheckOutPage1() 
{
String expURL="https://www.saucedemo.com/checkout-step-two.html";
String actURL=check1.InputInformationCheckOutPage1();
Assert.assertEquals(expURL, actURL);
Reporter.log("input info  "+ actURL);
}

   
@Test(priority=6, enabled=true) 
public void verifyURLOfCheckOutPage1() 
{
String expURL="https://www.saucedemo.com/checkout-step-one.html";
String actURL=check1.verifyURLOfCheckOutPage1();
Assert.assertEquals(expURL, actURL);
Reporter.log("URL of checkout page1 "+ actURL);
}
@Test(priority=5, enabled=true)
public void verifyTitleOfApplicationTest()
{
	String expTitle="Checkout: Your Information";
	String actTitle=check1.verifyTitleOfApplication();
	Assert.assertEquals(expTitle, actTitle);
	Reporter.log("Title of checkout page1 "+ actTitle);
	}
@Test(priority=3, enabled=true)
public void verifyCheckOutPageFbLogo() throws InterruptedException
{
	boolean result=check1.verifyCheckOutPageFbLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of checkout page fb Logo = " + result );
}
@Test(priority=4, enabled=true)
public void verifyCheckOutPageLinkedInLogo() throws InterruptedException
{
	boolean result=check1.verifyCheckOutPageLinkedInLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of checkout page linkedin Logo = " + result );
}
@Test(priority=2, enabled=true)
public void verifyChexkOutPageTwitterLogo() throws InterruptedException
{
	boolean result=check1.verifyChexkOutPageTwitterLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of checkout page twitter Logo = " + result );
}

@Test(priority=1, enabled=true)
public void clickOnCancelBtn()
{
	String expURL="https://www.saucedemo.com/cart.html";
	String actURL=check1.clickOnCancelBtn();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("Clickon cancelbtn of checkout page1 "+ actURL);
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
