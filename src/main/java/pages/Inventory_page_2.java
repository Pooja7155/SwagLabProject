package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.HandleDropdownList;

public class Inventory_page_2 extends TestBase
{
	// object repository
 @FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement shoppingcartlink;
 
 
  @FindBy(xpath="//span[@class='title']") private WebElement productsLable;
  @FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
  @FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDown;
  @FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
  //element added
  @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
  @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct ;
  @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtProduct;
  @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
  @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onsieProduct;
  @FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProduct;
  //element removed
  @FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removeBackpackProduct ;
  @FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement removeBikelightProduct  ;
  @FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeBoltTShirt  ;
  @FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removeJacketProduct  ;
  @FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement removeOnSieProduct;
  @FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removeRedTShirt  ;

  //constructor
  public Inventory_page_2()
  {
	PageFactory.initElements(driver, this);  
  }
  public String verifyproductsLable()
  {
	  return productsLable.getText();
  }
  public boolean verifytwitterLogo()
  {
	  return twitterLogo.isDisplayed();// true
  }
  public String add6Products()
  {
	 
	  HandleDropdownList.handleSelectClass(dropDown, "Price (low to high)");
	  backPackProduct.click();
	  bikeLightProduct.click();
	  boltTshirtProduct.click();
	  jacketProduct.click();
	  onsieProduct.click();
	  redTshirtProduct.click();

	  return cartCount.getText();
  }
	public String remove2Products() throws InterruptedException
	{
		add6Products();
		Thread.sleep(2000);
		removeBackpackProduct.click(); 
		removeBikelightProduct.click();
		 return cartCount.getText();
		 
		 
} 
	public String clickCart() throws InterruptedException
	{
		shoppingcartlink.click();
	return driver.getCurrentUrl();
		
	}
	
	}




