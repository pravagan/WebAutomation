package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAcctMsgHeading;

    @FindBy(xpath = "(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
    WebElement logout;

    public void clickLogout() {
        logout.click();
    }

    public boolean isMyAccountPageExists()
    {
       try
       {
           return (myAcctMsgHeading.isDisplayed());
       }
       catch(Exception e)
       {
           return false;
       }
    }
}
