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
import pages.cartPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class cartPageTest extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	cartPage cart;
	
   @BeforeMethod(alwaysRun = true)
   public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart=new cartPage();
		login.loginToApplication();
		invent.add6Products();
		invent.clickCart();
		
		
	}
   @Test
   public void verifyCartUrlApplication() throws EncryptedDocumentException, IOException
	{
		String expUrl="https://www.saucedemo.com/cart.html";
		String actUrl=cart.verifyCartUrlApplication();
		Assert.assertEquals(expUrl,actUrl); 
		
	}
   @Test
   public void verifyProductLableCart() throws EncryptedDocumentException, IOException
	{
		String expLable="Your Cart";
		String actLable=cart.verifyProductLableCart();
		Assert.assertEquals(expLable,actLable); 
	}
@Test
public void remove3ProductCartTest() throws InterruptedException, EncryptedDocumentException, IOException 
{
	String expCount="3";
	String actCount=cart.remove3ProductCart();
	Assert.assertEquals(expCount,actCount);
	
}
@Test
public void verifyContinueShoppingCartUrl() throws EncryptedDocumentException, IOException, InterruptedException
{
	String expURL="https://www.saucedemo.com/inventory.html";
	String actURL=cart.verifyContinueShoppingCartUrl();
	Assert.assertEquals(expURL, actURL);
}
@Test
public void verifyUrlCheckout() throws EncryptedDocumentException, IOException, InterruptedException
{
	String expURL="https://www.saucedemo.com/checkout-step-one.html";
	String actURL=cart.verifyUrlCheckout();
	Assert.assertEquals(expURL, actURL);
}
@Test
public void verifytQTYLable() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expLable="QTY";
		String actLable=cart.verifytQTYLable();
		Assert.assertEquals(expLable,actLable); 
	}
@Test
public void verifyCartDescriptionLable() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expLable="Description";
		String actLable=cart.verifyCartDescriptionLable();
		Assert.assertEquals(expLable,actLable); 
	}
@Test 
 public void verifyCartPageFbLogo() throws InterruptedException
 {
	boolean result=cart.verifyCartPageFbLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of Cart page Logo = " + result );
 }
   @Test
public void verifyCartPageLinkedInLogo() throws InterruptedException
{
	boolean result=cart.verifyCartPageLinkedInLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of Cart page Logo = " + result );

}
 @Test 
public void verifyCartPageTwitterLogo() throws InterruptedException
{
	boolean result=cart.verifyCartPageTwitterLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of Cart page Logo = " + result );

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
