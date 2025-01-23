package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {


    @Test//(groups = {"Regression","Master"})
    public void verify_account_registration()
    {

     logger.info(" ****** Starting TC001_AccountRegistrationTest ******* ");
     try {
         HomePage hp = new HomePage(driver);
         hp.clickMyAccount();
         logger.info(" ****** Clicked on MyAccount link ******* ");

         hp.clickRegister();
         logger.info(" ****** Clicked on Register link ******* ");

         AccountRegistrationPage actregpage = new AccountRegistrationPage(driver);
         logger.info(" ****** Providing Customer Details ******* ");

         actregpage.setTxtFirstname("Test2");
         actregpage.setTxtLastname("example2");
         actregpage.setTxtEmail("testex2@gmail.com");
         actregpage.setTxtTelephone("1234355");
         actregpage.setTxtPassword("abc123456");
         actregpage.settxtConfirmpassword("abc123456");
         actregpage.setChkAgree();
         actregpage.btnContinue();
         logger.info(" ****** Validating Registration Confirmation message ******* ");
         String confmsg = actregpage.getConfirmationMsg();
         if(confmsg.equals( "Your Account Has Been Created!"))
         {
             Assert.assertTrue(true);
         }
         else {
             logger.error("**** Test Failed ****");
             logger.debug("Debug logs");
             Assert.assertTrue(false);
         }
     } catch (Exception e) {
         Assert.fail();
     }
        logger.info(" ****** Finished TC001_AccountRegistrationTest ******* ");



    }
}
