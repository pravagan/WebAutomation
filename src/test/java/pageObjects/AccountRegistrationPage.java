package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txtFirstname;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtLastname;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtTelephone;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtConfirmpassword;
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkAgree;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setTxtFirstname(String fname) {
       txtFirstname.sendKeys(fname);
    }

    public void setTxtLastname(String lname) {
        txtLastname.sendKeys(lname);
    }

    public void setTxtEmail(String email) {
       txtEmail.sendKeys(email);
    }

    public void setTxtTelephone(String tel) {
   txtTelephone.sendKeys(tel);
    }

    public void setTxtPassword(String pwd) {
      txtPassword.sendKeys(pwd);
    }
    public void settxtConfirmpassword(String pwd) {
        txtConfirmpassword.sendKeys(pwd);
    }

    public void setChkAgree() {
        chkAgree.click();
    }
    public void btnContinue() {
        btnContinue.click();
    }

    public String getConfirmationMsg()
    {
    try{
        return msgConfirmation.getText();
        }
    catch (Exception e) {
       return e.getMessage();
    }
    }
}
