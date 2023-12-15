package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class cartPage extends TestBase 
{ 
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cart;
	@FindBy(xpath="//span[@class='title']") private WebElement productLable;
	
	

	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLight;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement  removeBackPack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTshirt;

	
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueShopping;
	
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtn;
	
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement qtyLable;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement descriptionLable;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement fbLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedInLogo;

   public cartPage()
   {
		PageFactory.initElements(driver, this);  
   }
  
   public String verifyCartUrlApplication()
   {
	   cart.click();
	   return driver.getCurrentUrl();
   }
   
   public String remove3ProductCart() throws InterruptedException
   {
	   cart.click();
	   removeBikeLight.click();
	   removeBackPack.click();
	   removeBoltTshirt.click();
	   Thread.sleep(2000);
	   return cartCount.getText();
   }
    
   public String verifyProductLableCart()
   {
	   cart.click();
	   return productLable.getText();
   }
   public String verifyContinueShoppingCartUrl() throws InterruptedException
   {
	   remove3ProductCart();
	   continueShopping.click();
	   return driver.getCurrentUrl();
   }
   public String verifyUrlCheckout () throws InterruptedException
   {
	   remove3ProductCart();
	   checkoutBtn.click();
	   Thread.sleep(2000);
	   return driver.getCurrentUrl();
   }
   public String verifytQTYLable () throws InterruptedException
   {	  
	   remove3ProductCart();
       return qtyLable.getText();
	    }
   public String verifyCartDescriptionLable () throws InterruptedException
   {
	   remove3ProductCart();
       return descriptionLable.getText();
   }
   public boolean  verifyCartPageFbLogo() throws InterruptedException
   {
	   remove3ProductCart();
	   return fbLogo.isDisplayed();
   }
   public boolean verifyCartPageLinkedInLogo() throws InterruptedException
   {
	   remove3ProductCart();
	   return linkedInLogo.isDisplayed();
   }
   public boolean verifyCartPageTwitterLogo () throws InterruptedException
   {
	   remove3ProductCart();
	   return twitterLogo.isDisplayed();
   }
   public String clickOnCheckOutBtn()
   {
	   checkoutBtn.click();
	   return driver.getCurrentUrl();
   }
}
