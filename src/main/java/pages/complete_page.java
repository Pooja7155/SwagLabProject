package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class complete_page extends TestBase
{
 @FindBy(xpath="//span[@class='title']") private WebElement completeTitle;
 @FindBy(xpath="//h2[@class='complete-header']") private WebElement thxforOrder;
 @FindBy(xpath="//button[@class='btn btn_primary btn_small']") private WebElement backToHome;
 @FindBy(xpath="//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']") private WebElement textYourOrder;
 
 

public complete_page()
{
PageFactory.initElements(driver, this);
}
public String verifycompleteurl()
{
	 return driver.getCurrentUrl();
}

public String verifycheckoutCompleteLable()
{
return completeTitle.getText();
}
public String verifyThankyouMessage()
{
return thxforOrder.getText();
}
public String verifyYourOrderMessage()
{
return textYourOrder.getText();
}
public String verifyBackHomebtn()
{
	backToHome.click();
return driver.getCurrentUrl();
}








}
