package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath="(//span[normalize-space()='My Account'])[1]")
    WebElement lnkMyaccount;
@FindBy(xpath ="(//a[normalize-space()='Register'])[1]" )
    WebElement lnkRegister;
@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
    WebElement lnklogin;

public void clickMyAccount()
{
    lnkMyaccount.click();
}

public void clickRegister()
    {
        lnkRegister.click();
    }

    public void clickLnklogin() {
        lnklogin.click();
    }
}
