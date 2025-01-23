package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
    @BeforeClass//(groups = {"Sanity","Regression","Master"})
    @Parameters({"browser"})
    public void setup(String br) throws IOException {
        // LOADING config.properties FILE
        FileReader file=new FileReader("/Users/sriramjakkaraju/IdeaProjects/WebAutomation/src/test/resources/config.properties");
        p=new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());

        switch(br.toLowerCase())
        {
            case "chrome" : driver=new ChromeDriver(); break;
            case "firefox" : driver=new FirefoxDriver(); break;
            case "safari" : driver=new SafariDriver(); break;
            case "edge" : driver=new EdgeDriver(); break;
            default: System.out.println("Invalid browser name"); return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL")); // reading URL from properties file
        driver.manage().window().maximize();

    }

    @AfterClass//(groups = {"Sanity","Regression","Master"})
    public void teardown()
    {
        driver.quit();
    }

}
