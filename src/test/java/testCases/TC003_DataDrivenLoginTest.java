package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.ExcelDataProvider;

public class TC003_DataDrivenLoginTest extends BaseClass{

    @Test(dataProvider = "LoginTestData",dataProviderClass = ExcelDataProvider.class) //getting data provider from different class


    public void verify_loginDDT(String email,String password, String expres) {

        logger.info(" ***** starting DDTLogin Test***** ");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLnklogin();
            logger.info(" ***** Clicked on Login link ***** ");

            LoginPage lp = new LoginPage(driver);
            lp.setEmailaddress(email);
            lp.setPassword(password);
            lp.clickCustlogin();
            logger.info(" ***** Entered Login credentials and clicked on Login link ***** ");

            MyAccountPage map = new MyAccountPage(driver);
            boolean targetpage = map.isMyAccountPageExists();

        /* Data is Valid -   Login success - test pass - logout
                             Login Failed - test fail
           Data is Invalid - Login success - test fail - logout
                             Login Failed - test pass
        */

            if (expres.equalsIgnoreCase("valid")) {
                if (targetpage == true) {
                    map.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            } else {
                if (targetpage == true) {
                    map.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }

        }
        catch (Exception e)
        {
            Assert.fail();
        }

        logger.info(" ***** Finished DDTLogin Test***** ");

    }
}
