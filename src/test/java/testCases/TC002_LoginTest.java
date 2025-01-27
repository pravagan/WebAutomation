package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{

    @Test//(groups = {"Sanity","Master"})
    public void verify_login()
    {
        logger.info(" ***** starting Login Test***** ");

        try {

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLnklogin();
            logger.info(" ***** Clicked on Login link ***** ");

            LoginPage lp = new LoginPage(driver);
            lp.setEmailaddress(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickCustlogin();
            logger.info(" ***** Entered Login credentials and clicked on Login link ***** ");

            MyAccountPage map = new MyAccountPage(driver);
            boolean targetpage = map.isMyAccountPageExists();
            Assert.assertEquals(targetpage, true, "Login failed");
        }
        catch (Exception e)
        {
            Assert.fail();
        }

        logger.info(" ***** finished Login Test***** ");

    }
}
