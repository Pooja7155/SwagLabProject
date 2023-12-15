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
import pages.check_out_page_2;
import utility.CaptureScreenshot;

public class check_out_page2_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	cartPage cart;
	Check_Out_Page1 check1;
	check_out_page_2 check2;
	
   @BeforeMethod(alwaysRun = true)
   
   public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart=new cartPage();
		check1=new Check_Out_Page1();
		check2=new check_out_page_2();
		login.loginToApplication();
		invent.add6Products();
		invent.clickCart();
		cart.clickOnCheckOutBtn();
		check1.InputInformationCheckOutPage1();
		
		
		
		

		
	}
@Test(priority=2, enabled=true)
public void TitleOfApplication()
{
	String expLabel="Checkout: Overview";
	String actLabel=check2.verifyTitleOfApplication();
	Assert.assertEquals(expLabel, actLabel);
	Reporter.log("label of check out page 2 "+ actLabel);
	}

@Test(priority=1, enabled=true)
public void clickOnFinishBtnTest()
{
	String expURL="https://www.saucedemo.com/checkout-complete.html";
			String actURL=check2.clickOnFinishBtn();
			Assert.assertEquals(expURL, actURL);
			Reporter.log("finishBtn of check out page 2 "+ actURL);
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


	

