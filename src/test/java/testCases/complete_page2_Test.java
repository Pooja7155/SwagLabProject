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
import pages.complete_page;
import utility.CaptureScreenshot;

public class complete_page2_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	cartPage cart;
	Check_Out_Page1 check1;
	check_out_page_2 check2;
	complete_page check3;
	
   @BeforeMethod(alwaysRun = true)
   
   public void setup() throws InterruptedException, IOException
   {initialization();
	login=new LoginPage();
	invent=new Inventory_page_2();
	cart=new cartPage();
	check1=new Check_Out_Page1();
	check2=new check_out_page_2();
	check3=new complete_page();
	login.loginToApplication();
	invent.add6Products();
	invent.clickCart();
	cart.clickOnCheckOutBtn();
	check1.InputInformationCheckOutPage1();
	check2.clickOnFinishBtn();
	}
   @Test(priority=4, enabled=true)
   public void verifycheckoutCompleteLableTest()
   {
   String expLable="Checkout: Complete!";
   String actLable=check3.verifycheckoutCompleteLable();
   Assert.assertEquals(expLable, actLable);
   Reporter.log("Complete Level Page Lable "+actLable);
   }
   /*@Test
   public void imagedisplayTest() {
   boolean result=check3.imagedisplay();
   Assert.assertEquals(result, true);
   Reporter.log("Visibility of Image = " +result);
   }*/
   @Test(priority=3, enabled=true)
   public void verifyThankyouMessageTest()
   {
   String expText="Thank you for your order!";
   String actText=check3.verifyThankyouMessage();
   Assert.assertEquals(expText, actText);
   Reporter.log("Text Message Thank You "+actText);
   }
   @Test(priority=1, enabled=true)
   public void verifyYourOrderMessageTest()
   {
   String expText="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
   String actText=check3.verifyYourOrderMessage();
   Assert.assertEquals(expText, actText);
   Reporter.log("Text Message You Order "+actText);
   }
   @Test(priority=2, enabled=true)
   public void verifyBackHomebtnTest()
   {
   String expUrl="https://www.saucedemo.com/inventory.html";
   String actUrl=check3.verifyBackHomebtn();
   Assert.assertEquals(expUrl, actUrl);
   Reporter.log("Url of Page "+actUrl);
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