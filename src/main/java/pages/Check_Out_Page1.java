package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Check_Out_Page1  extends TestBase
{
  @FindBy(xpath="//span[@class='title']") private WebElement titleOfChkOutPage   ;
  @FindBy(xpath="//input[@name='firstName']") private WebElement  firstnameTextBox  ;
  @FindBy(xpath="//input[@name='lastName']") private WebElement   lastnameTextBox  ;
  @FindBy(xpath="//input[@name='postalCode']") private WebElement  ZipcodeTextBox   ;
  @FindBy(xpath="//input[@name='continue']") private WebElement  continueBtn    ;
  @FindBy(xpath="//button[@class='btn btn_secondary back btn_medium cart_cancel_link']") private WebElement cancelBtn;
 
  @FindBy(xpath="//a[text()='Twitter']")private WebElement TwitterLogo;
  @FindBy(xpath="//a[text()='Facebook']")private WebElement facebookLogo;
  @FindBy(xpath="//a[text()='LinkedIn']")private WebElement linkedinLogo;

  
  public Check_Out_Page1()
  {
	  PageFactory.initElements(driver, this);
	  
  }
  
  public String verifyURLOfCheckOutPage1()
  {
	  return driver.getCurrentUrl();
  }
  public String verifyTitleOfApplication()
  {
	  return titleOfChkOutPage.getText();
  }
  public String InputInformationCheckOutPage1()
  {
	  firstnameTextBox.sendKeys("Pooja");
	  lastnameTextBox.sendKeys("Kulkarni");
	  ZipcodeTextBox.sendKeys("431602");
	  continueBtn.click();
	  return driver.getCurrentUrl();
  }
  
  /*public String verifycontinuebtn()
  {  
	  continueBtn.click();
	   return driver.getCurrentUrl();
  }*/
  
  public boolean  verifyCheckOutPageFbLogo() throws InterruptedException
  {
	  
	   return facebookLogo.isDisplayed();
  }
  public boolean verifyCheckOutPageLinkedInLogo() throws InterruptedException
  {
	   
	   return linkedinLogo.isDisplayed();
  }
  public boolean verifyChexkOutPageTwitterLogo () throws InterruptedException
  {
	   return TwitterLogo.isDisplayed();
  }
 /* public String verifyOnContinueBtn()
  {
	  continueBtn.click();
	   return driver.getCurrentUrl();
  }*/
  public String clickOnCancelBtn()
  {
	  cancelBtn.click();
	   return driver.getCurrentUrl();
  }
  public String ClickonContinueBtn()
  {
	  continueBtn.click();
	  return driver.getCurrentUrl();
  }
  
 
  
  
  
}
